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
package id.jrosmessages.tests.msgs;

import id.jrosmessages.Array;
import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

@MessageMetadata(
        name = "jros_msgs/Test",
        fields = {"bool_array", "data", "bool_fixed_array"},
        md5sum = "random")
public class TestMessage implements Message {

    public int data;
    public boolean[] bool_array = new boolean[0];

    @Array(size = 3)
    public boolean[] bool_fixed_array = new boolean[0];

    public TestMessage withData(int data) {
        this.data = data;
        return this;
    }

    public TestMessage withBoolFixedArray(boolean[] bool_fixed_array) {
        this.bool_fixed_array = bool_fixed_array;
        return this;
    }

    public TestMessage withBoolArray(boolean[] bool_array) {
        this.bool_array = bool_array;
        return this;
    }

    @Override
    public String toString() {
        return XJson.asString(
                        "data",
                        data,
                        "bool_array",
                        bool_array,
                        "bool_fixed_array",
                        bool_fixed_array)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, bool_array, bool_fixed_array);
    }

    @Override
    public boolean equals(Object obj) {
        TestMessage other = (TestMessage) obj;
        return Objects.equals(data, other.data)
                && Arrays.equals(bool_array, other.bool_array)
                && Arrays.equals(bool_fixed_array, other.bool_fixed_array);
    }
}
