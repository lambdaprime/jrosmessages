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
package id.jrosmessages.std_msgs;

import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.xfunction.XJson;
import java.util.Objects;

/**
 * Definition for std_msgs/UInt16
 *
 * <p>This was originally provided as an example message.
 *
 * <p>It is deprecated as of Foxy
 *
 * <p>It is recommended to create your own semantically meaningful message.
 *
 * <p>However if you would like to continue using this please use the equivalent in example_msgs.
 */
@MessageMetadata(name = UInt16Message.NAME, md5sum = "1df79edf208b629fe6b81923a544552d")
public class UInt16Message implements Message {

    static final String NAME = "std_msgs/UInt16";

    public short data;

    public UInt16Message withData(short data) {
        this.data = data;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (UInt16Message) obj;
        return Objects.equals(data, other.data);
    }

    @Override
    public String toString() {
        return XJson.asString("data", data);
    }
}
