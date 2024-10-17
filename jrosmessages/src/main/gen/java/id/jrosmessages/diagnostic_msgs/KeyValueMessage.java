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
import java.util.Objects;

/** Definition for diagnostic_msgs/KeyValue */
@MessageMetadata(
        name = KeyValueMessage.NAME,
        fields = {"key", "value"},
        md5sum = "cf57fdc6617a881a88c16e768132149c")
public class KeyValueMessage implements Message {

    static final String NAME = "diagnostic_msgs/KeyValue";

    /** What to label this value when viewing. */
    public StringMessage key = new StringMessage();

    /** A value to track over time. */
    public StringMessage value = new StringMessage();

    public KeyValueMessage withKey(StringMessage key) {
        this.key = key;
        return this;
    }

    public KeyValueMessage withValue(StringMessage value) {
        this.value = value;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof KeyValueMessage other)
            return Objects.equals(key, other.key) && Objects.equals(value, other.value);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "key", key,
                "value", value);
    }
}
