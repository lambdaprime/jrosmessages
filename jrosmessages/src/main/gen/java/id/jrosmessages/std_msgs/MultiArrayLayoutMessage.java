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
 * Definition for std_msgs/MultiArrayLayout This was originally provided as an example message. # It
 * is deprecated as of Foxy # It is recommended to create your own semantically meaningful message.
 * # However if you would like to continue using this please use the equivalent in example_msgs.
 *
 * <p># The multiarray declares a generic multi-dimensional array of a # particular data type.
 * Dimensions are ordered from outer most # to inner most. # # Accessors should ALWAYS be written in
 * terms of dimension stride # and specified outer-most dimension first. # # multiarray(i,j,k) =
 * data[data_offset + dim_stride[1]*i + dim_stride[2]*j + k] # # A standard, 3-channel 640x480 image
 * with interleaved color channels # would be specified as: # # dim[0].label = "height" #
 * dim[0].size = 480 # dim[0].stride = 3*640*480 = 921600 (note dim[0] stride is just size of image)
 * # dim[1].label = "width" # dim[1].size = 640 # dim[1].stride = 3*640 = 1920 # dim[2].label =
 * "channel" # dim[2].size = 3 # dim[2].stride = 3 # # multiarray(i,j,k) refers to the ith row, jth
 * column, and kth channel.
 */
@MessageMetadata(name = MultiArrayLayoutMessage.NAME)
public class MultiArrayLayoutMessage implements Message {

    static final String NAME = "std_msgs/MultiArrayLayout";

    /** Array of dimension properties */
    public MultiArrayDimensionMessage[] dim = new MultiArrayDimensionMessage[0];

    /** padding bytes at front of data */
    public int data_offset;

    public MultiArrayLayoutMessage withDim(MultiArrayDimensionMessage... dim) {
        this.dim = dim;
        return this;
    }

    public MultiArrayLayoutMessage withDataOffset(int data_offset) {
        this.data_offset = data_offset;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(dim), data_offset);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (MultiArrayLayoutMessage) obj;
        return Arrays.equals(dim, other.dim) && data_offset == other.data_offset;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "dim", dim,
                "data_offset", data_offset);
    }
}
