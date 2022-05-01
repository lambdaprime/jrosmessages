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

/** Definition for geometry_msgs/Quaternion */
@MessageMetadata(name = QuaternionMessage.NAME, md5sum = "a779879fadf0160734f906b8c19c7004")
public class QuaternionMessage implements Message {

    static final String NAME = "geometry_msgs/Quaternion";

    public double x, y, z, w;

    public QuaternionMessage() {
        // TODO Auto-generated constructor stub
    }

    public QuaternionMessage(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public QuaternionMessage withX(double x) {
        this.x = x;
        return this;
    }

    public QuaternionMessage withY(double y) {
        this.y = y;
        return this;
    }

    public QuaternionMessage withZ(double z) {
        this.z = z;
        return this;
    }

    public QuaternionMessage withW(double w) {
        this.w = w;
        return this;
    }

    @Override
    public String toString() {
        return XJson.asString("x", x, "y", y, "z", z, "w", w);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
    }

    @Override
    public boolean equals(Object obj) {
        QuaternionMessage other = (QuaternionMessage) obj;
        return Objects.equals(x, other.x)
                && Objects.equals(y, other.y)
                && Objects.equals(z, other.z)
                && Objects.equals(w, other.w);
    }
}
