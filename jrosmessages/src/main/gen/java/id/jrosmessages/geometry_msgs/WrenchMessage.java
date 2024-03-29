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
package id.jrosmessages.geometry_msgs;

import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.xfunction.XJson;
import java.util.Objects;

/**
 * Definition for geometry_msgs/Wrench This represents force in free space, separated into # its
 * linear and angular parts.
 */
@MessageMetadata(
        name = WrenchMessage.NAME,
        fields = {"force", "torque"},
        md5sum = "4f539cf138b23283b520fd271b567936")
public class WrenchMessage implements Message {

    static final String NAME = "geometry_msgs/Wrench";

    public Vector3Message force = new Vector3Message();

    public Vector3Message torque = new Vector3Message();

    public WrenchMessage withForce(Vector3Message force) {
        this.force = force;
        return this;
    }

    public WrenchMessage withTorque(Vector3Message torque) {
        this.torque = torque;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(force, torque);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (WrenchMessage) obj;
        return Objects.equals(force, other.force) && Objects.equals(torque, other.torque);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "force", force,
                "torque", torque);
    }
}
