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
package id.jrosmessages.geometry_msgs;

import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.xfunction.XJson;
import java.util.Objects;

/** Definition for geometry_msgs/Vector3 */
@MessageMetadata(
        name = Vector3Message.NAME,
        fields = {"x", "y", "z"},
        md5sum = "4a842b65f413084dc2b10fb484ea7f17")
public class Vector3Message implements Message {

    static final String NAME = "geometry_msgs/Vector3";

    public double x, y, z;

    public Vector3Message() {}

    public Vector3Message(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3Message withX(double x) {
        this.x = x;
        return this;
    }

    public Vector3Message withY(double y) {
        this.y = y;
        return this;
    }

    public Vector3Message withZ(double z) {
        this.z = z;
        return this;
    }

    @Override
    public String toString() {
        return XJson.asString("x", x, "y", y, "z", z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public boolean equals(Object obj) {
        Vector3Message other = (Vector3Message) obj;
        return Objects.equals(x, other.x)
                && Objects.equals(y, other.y)
                && Objects.equals(z, other.z);
    }
}
