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
 * Definition for std_msgs/MultiArrayDimension This was originally provided as an example message. #
 * It is deprecated as of Foxy # It is recommended to create your own semantically meaningful
 * message. # However if you would like to continue using this please use the equivalent in
 * example_msgs.
 */
@MessageMetadata(name = MultiArrayDimensionMessage.NAME)
public class MultiArrayDimensionMessage implements Message {

    static final String NAME = "std_msgs/MultiArrayDimension";

    /** label of given dimension */
    public StringMessage label = new StringMessage();

    /** size of given dimension (in type units) */
    public int size;

    /** stride of given dimension */
    public int stride;

    public MultiArrayDimensionMessage() {}

    public MultiArrayDimensionMessage(String label, int size, int stride) {
        this.label = new StringMessage(label);
        this.size = size;
        this.stride = stride;
    }

    public MultiArrayDimensionMessage withLabel(StringMessage label) {
        this.label = label;
        return this;
    }

    public MultiArrayDimensionMessage withSize(int size) {
        this.size = size;
        return this;
    }

    public MultiArrayDimensionMessage withStride(int stride) {
        this.stride = stride;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, size, stride);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (MultiArrayDimensionMessage) obj;
        return Objects.equals(label, other.label) && size == other.size && stride == other.stride;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "label", label,
                "size", size,
                "stride", stride);
    }
}
