/*
 * Copyright 2022 jrosclient project
 * 
 * Website: https://github.com/lambdaprime/jrosmessages
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package id.jrosmessages.impl;

import id.jrosmessages.JRosMessageMetrics;
import id.jrosmessages.Message;
import id.jrosmessages.MessageDescriptor;
import id.kineticstreamer.KineticStreamReader;
import id.kineticstreamer.KineticStreamWriter;
import id.kineticstreamer.PublicStreamedFieldsProvider;
import id.kineticstreamer.StreamedFieldsProvider;
import id.xfunction.io.XOutputStream;
import id.xfunction.logging.TracingToken;
import id.xfunction.logging.XLogger;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.Meter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.logging.Level;

/**
 * Performs message (de)serialization (from)to stream of bytes.
 *
 * <p>Thread safe.
 *
 * @see <a href="https://wiki.ros.org/msg">msg specification</a>
 * @author lambdaprime intid@protonmail.com
 */
public abstract class AbstractMessageSerializationUtils {
    private final Meter METER =
            GlobalOpenTelemetry.getMeter(AbstractMessageSerializationUtils.class.getSimpleName());
    private final LongHistogram MESSAGE_SERIALIZATION_TIME_METER =
            METER.histogramBuilder(JRosMessageMetrics.MESSAGE_SERIALIZATION_TIME_METRIC)
                    .setDescription(
                            JRosMessageMetrics.MESSAGE_SERIALIZATION_TIME_METRIC_DESCRIPTION)
                    .ofLongs()
                    .build();
    private final LongHistogram MESSAGE_DESERIALIZATION_TIME_METER =
            METER.histogramBuilder(JRosMessageMetrics.MESSAGE_DESERIALIZATION_TIME_METRIC)
                    .setDescription(
                            JRosMessageMetrics.MESSAGE_DESERIALIZATION_TIME_METRIC_DESCRIPTION)
                    .ofLongs()
                    .build();

    protected static final StreamedFieldsProvider FIELDS_PROVIDER =
            new PublicStreamedFieldsProvider(
                    clazz -> new MessageDescriptor((Class<Message>) clazz).readFields());

    private XLogger logger;
    private Attributes metricAttributes;

    /**
     * @param metricAttributes many metrics are shared between all jrosmessages implementations:
     *     jros2messages, jros1messages. These attributes allow to identify metrics for
     *     jros2messages.
     */
    public AbstractMessageSerializationUtils(
            @SuppressWarnings("exports") TracingToken tracingToken,
            Map<String, String> metricAttributes) {
        var attrBuilder = Attributes.builder();
        metricAttributes.forEach((k, v) -> attrBuilder.put(k, v));
        this.metricAttributes = attrBuilder.build();
        logger = XLogger.getLogger(AbstractMessageSerializationUtils.class, tracingToken);
    }

    /**
     * Deserialize message from byte stream
     *
     * @param <M> type of the message
     * @param data byte array with the message
     * @param clazz message class
     */
    public <M extends Message> M read(byte[] data, Class<M> clazz) {
        var startAt = Instant.now();
        var className = clazz.getName();
        if (logger.isLoggable(Level.FINER)) {
            logger.entering(
                    "read", new Object[] {"className=" + className, "rawData=" + toString(data)});
        } else {
            logger.fine("Reading message: {0}", className);
        }
        try {
            var buf = ByteBuffer.wrap(data);
            var ks = newKineticStreamReader(buf);
            Object obj = ks.read(clazz);
            if (logger.isLoggable(Level.FINER)) {
                logger.exiting("read", obj);
            }
            return (M) obj;
        } catch (Exception e) {
            throw new RuntimeException("Problem reading " + className, e);
        } catch (Error e) {
            logger.severe("Problem reading {0}: {1}", className, e.getClass().getSimpleName());
            throw e;
        } finally {
            MESSAGE_DESERIALIZATION_TIME_METER.record(
                    Duration.between(startAt, Instant.now()).toMillis(), metricAttributes);
        }
    }

    /**
     * Serialize message to byte stream
     *
     * @param message message to serialize
     */
    public byte[] write(Message message) {
        var startAt = Instant.now();
        var className = message.getClass().getName();
        if (logger.isLoggable(Level.FINER)) {
            logger.entering("write", new Object[] {className, message});
        } else {
            logger.fine("Writing message: {0}", className);
        }
        try {
            var bos = new ByteArrayOutputStream();
            var dos = new DataOutputStream(bos);
            var ks = newKineticStreamWriter(dos);
            ks.write(message);
            var body = postProc(bos.toByteArray());
            if (logger.isLoggable(Level.FINER)) {
                logger.exiting("write", (Object) "raw data=" + toString(body));
            }
            return body;
        } catch (Exception e) {
            throw new RuntimeException("Problem writing " + className, e);
        } catch (Error e) {
            logger.severe("Problem reading {0}: {1}", className, e.getClass().getName());
            throw e;
        } finally {
            MESSAGE_SERIALIZATION_TIME_METER.record(
                    Duration.between(startAt, Instant.now()).toMillis(), metricAttributes);
        }
    }

    protected abstract KineticStreamReader newKineticStreamReader(ByteBuffer buf);

    protected abstract KineticStreamWriter newKineticStreamWriter(DataOutputStream dos);

    protected String toString(byte[] obj) {
        var out = new XOutputStream();
        try {
            new ByteArrayInputStream(obj).transferTo(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "[" + out.asHexString() + "]";
    }

    protected byte[] postProc(byte[] rawMessage) {
        return rawMessage;
    }
}
