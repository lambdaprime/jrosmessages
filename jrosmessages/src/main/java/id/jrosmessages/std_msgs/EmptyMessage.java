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

/** Definition for std_msgs/Empty */
@MessageMetadata(name = "std_msgs/Empty", md5sum = "d41d8cd98f00b204e9800998ecf8427e")
public class EmptyMessage implements Message {

    // for kineticstreamer
    public EmptyMessage() {}

    @Override
    public String toString() {
        return "{}";
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof EmptyMessage;
    }
}
