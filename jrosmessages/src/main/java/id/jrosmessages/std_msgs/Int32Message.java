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
package id.jrosmessages.std_msgs;

import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.xfunction.XJson;
import java.util.Objects;

/** Definition for std_msgs/Int32 */
@MessageMetadata(name = "std_msgs/Int32", md5sum = "da5909fbe378aeaf85e547e830cc1bb7")
public class Int32Message implements Message {

    public int data;

    public Int32Message withData(int data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return XJson.asString("data", data).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }

    @Override
    public boolean equals(Object obj) {
        Int32Message other = (Int32Message) obj;
        return Objects.equals(data, other.data);
    }
}
