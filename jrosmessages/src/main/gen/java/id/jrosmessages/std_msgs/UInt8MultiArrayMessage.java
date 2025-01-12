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
import java.util.Arrays;
import java.util.Objects;

/**
 * Definition for std_msgs/UInt8MultiArray
 *
 * <p>This was originally provided as an example message. It is deprecated as of Foxy It is
 * recommended to create your own semantically meaningful message. However if you would like to
 * continue using this please use the equivalent in example_msgs. This was originally provided as an
 * example message. It is deprecated as of Foxy It is recommended to create your own semantically
 * meaningful message. However if you would like to continue using this please use the equivalent in
 * example_msgs.
 *
 * <p>Please look at the MultiArrayLayout message definition for documentation on all multiarrays.
 */
@MessageMetadata(
        name = UInt8MultiArrayMessage.NAME,
        fields = {"layout", "data"},
        md5sum = "82373f1612381bb6ee473b5cd6f5d89c")
public class UInt8MultiArrayMessage implements Message {

    static final String NAME = "std_msgs/UInt8MultiArray";

    /** specification of data layout */
    public MultiArrayLayoutMessage layout = new MultiArrayLayoutMessage();

    /** array of data */
    public byte[] data = new byte[0];

    public UInt8MultiArrayMessage withLayout(MultiArrayLayoutMessage layout) {
        this.layout = layout;
        return this;
    }

    public UInt8MultiArrayMessage withData(byte... data) {
        this.data = data;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(layout, Arrays.hashCode(data));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UInt8MultiArrayMessage other)
            return Objects.equals(layout, other.layout) && Arrays.equals(data, other.data);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "layout", layout,
                "data", data);
    }
}
