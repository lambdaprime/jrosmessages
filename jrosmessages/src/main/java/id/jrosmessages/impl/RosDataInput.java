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

import id.jrosmessages.MessageFormat;
import id.kineticstreamer.InputKineticStream;
import id.kineticstreamer.KineticStreamReader;
import id.xfunction.logging.XLogger;
import java.io.DataInput;
import java.io.IOException;
import java.lang.reflect.Array;

public class RosDataInput implements InputKineticStream {

    private static final XLogger LOGGER = XLogger.getLogger(RosDataInput.class);

    private DataInput in;
    private MessageFormat messageFormat;

    public RosDataInput(DataInput in) {
        this(in, MessageFormat.ROS1);
    }

    public RosDataInput(DataInput in, MessageFormat messageFormat) {
        this.in = in;
        this.messageFormat = messageFormat;
    }

    @Override
    public int readInt() throws IOException {
        return Integer.reverseBytes(in.readInt());
    }

    @Override
    public String readString() throws IOException {
        LOGGER.entering("readString");
        int len = readLen();
        byte[] b = new byte[len];
        in.readFully(b);
        if (messageFormat == MessageFormat.ROS2) {
            // if string ended with null byte we ignore it.
            // This is mainly for ROS2 strings.
            if (b.length > 0 && b[b.length - 1] == 0) len--;
        }
        var value = new String(b, 0, len);
        LOGGER.exiting("readString", value);
        return value;
    }

    public int readLen() throws IOException {
        return Integer.reverseBytes(in.readInt());
    }

    @Override
    public double readDouble() throws IOException {
        LOGGER.entering("readDouble");
        var value =
                Double.longBitsToDouble(
                        Long.reverseBytes(Double.doubleToRawLongBits(in.readDouble())));
        LOGGER.exiting("readDouble", value);
        return value;
    }

    @Override
    public float readFloat() throws IOException {
        LOGGER.entering("readFloat");
        var value =
                Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(in.readFloat())));
        LOGGER.exiting("readFloat", value);
        return value;
    }

    @Override
    public boolean readBool() throws IOException {
        LOGGER.entering("readBool");
        var value = in.readBoolean();
        LOGGER.exiting("readBool", value);
        return value;
    }

    @Override
    public Object[] readArray(Class<?> type) throws Exception {
        LOGGER.entering("readArray");
        var array = (Object[]) Array.newInstance(type, readLen());
        for (int i = 0; i < array.length; i++) {
            array[i] = new KineticStreamReader(this).read(type);
        }
        LOGGER.exiting("readArray");
        return array;
    }

    @Override
    public void close() throws Exception {
        // nothing to release
    }

    @Override
    public byte readByte() throws Exception {
        LOGGER.entering("readByte");
        var value = in.readByte();
        LOGGER.exiting("readByte");
        return value;
    }

    @Override
    public byte[] readByteArray() throws Exception {
        LOGGER.entering("readByteArray");
        var array = new byte[readLen()];
        for (int i = 0; i < array.length; i++) {
            array[i] = in.readByte();
        }
        LOGGER.exiting("readByteArray");
        return array;
    }

    @Override
    public int[] readIntArray() throws Exception {
        throw new RuntimeException("Not supported");
    }

    @Override
    public double[] readDoubleArray() throws Exception {
        LOGGER.entering("readDoubleArray");
        var array = new double[readLen()];
        for (int i = 0; i < array.length; i++) {
            array[i] = readDouble();
        }
        LOGGER.exiting("readDoubleArray");
        return array;
    }

    @Override
    public boolean[] readBooleanArray() throws Exception {
        LOGGER.entering("readBooleanArray");
        var array = new boolean[readLen()];
        for (int i = 0; i < array.length; i++) {
            array[i] = readBool();
        }
        LOGGER.exiting("readBooleanArray");
        return array;
    }
}
