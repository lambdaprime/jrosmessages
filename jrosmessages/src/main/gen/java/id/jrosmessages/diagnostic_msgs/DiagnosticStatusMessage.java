/*
 * Copyright 2021 jrosclient project
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
package id.jrosmessages.diagnostic_msgs;

import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/**
 * Definition for diagnostic_msgs/DiagnosticStatus
 *
 * <p>This message holds the status of an individual component of the robot.
 */
@MessageMetadata(
        name = DiagnosticStatusMessage.NAME,
        fields = {"level", "name", "message", "hardware_id", "values"},
        md5sum = "d0ce08bc6e5ba34c7754f563a9cabaf1")
public class DiagnosticStatusMessage implements Message {

    static final String NAME = "diagnostic_msgs/DiagnosticStatus";

    /** Possible levels of operations. */
    public enum LevelType {
        OK,

        WARN,

        ERROR,

        STALE,
    }

    /** Level of operation enumerated above. */
    public byte level;

    /** A description of the test/component reporting. */
    public StringMessage name = new StringMessage();

    /** A description of the status. */
    public StringMessage message = new StringMessage();

    /** A hardware unique string. */
    public StringMessage hardware_id = new StringMessage();

    /** An array of values associated with the status. */
    public KeyValueMessage[] values = new KeyValueMessage[0];

    public DiagnosticStatusMessage withLevel(byte level) {
        this.level = level;
        return this;
    }

    public DiagnosticStatusMessage withLevel(LevelType level) {
        this.level = (byte) level.ordinal();
        return this;
    }

    public DiagnosticStatusMessage withName(StringMessage name) {
        this.name = name;
        return this;
    }

    public DiagnosticStatusMessage withMessage(StringMessage message) {
        this.message = message;
        return this;
    }

    public DiagnosticStatusMessage withHardwareId(StringMessage hardware_id) {
        this.hardware_id = hardware_id;
        return this;
    }

    public DiagnosticStatusMessage withValues(KeyValueMessage... values) {
        this.values = values;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, name, message, hardware_id, Arrays.hashCode(values));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DiagnosticStatusMessage other)
            return level == other.level
                    && Objects.equals(name, other.name)
                    && Objects.equals(message, other.message)
                    && Objects.equals(hardware_id, other.hardware_id)
                    && Arrays.equals(values, other.values);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "level", level,
                "name", name,
                "message", message,
                "hardware_id", hardware_id,
                "values", values);
    }
}
