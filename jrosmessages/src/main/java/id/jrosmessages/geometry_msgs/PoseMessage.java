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

/** Definition for geometry_msgs/Pose */
@MessageMetadata(
        name = PoseMessage.NAME,
        fields = {"position", "orientation"},
        md5sum = "e45d45a5a1ce597b249e23fb30fc871f")
public class PoseMessage implements Message {

    static final String NAME = "geometry_msgs/Pose";

    public PointMessage position = new PointMessage();

    public QuaternionMessage orientation = new QuaternionMessage();

    public PoseMessage withPosition(PointMessage position) {
        this.position = position;
        return this;
    }

    public PoseMessage withQuaternion(QuaternionMessage orientation) {
        this.orientation = orientation;
        return this;
    }

    @Override
    public String toString() {
        return XJson.asString("position", position, "orientation", orientation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, orientation);
    }

    @Override
    public boolean equals(Object obj) {
        PoseMessage other = (PoseMessage) obj;
        return Objects.equals(position, other.position)
                && Objects.equals(orientation, other.orientation);
    }
}
