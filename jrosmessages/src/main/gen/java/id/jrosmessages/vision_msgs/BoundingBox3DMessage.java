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
package id.jrosmessages.vision_msgs;

import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.geometry_msgs.PoseMessage;
import id.jrosmessages.geometry_msgs.Vector3Message;
import id.xfunction.XJson;
import java.util.Objects;

/**
 * Definition for vision_msgs/BoundingBox3D A 3D bounding box that can be positioned and rotated
 * about its center (6 DOF) # Dimensions of this box are in meters, and as such, it may be migrated
 * to # another package, such as geometry_msgs, in the future.
 */
@MessageMetadata(name = BoundingBox3DMessage.NAME, md5sum = "727c83f2b037373b8e968433d9c84ecb")
public class BoundingBox3DMessage implements Message {

    static final String NAME = "vision_msgs/BoundingBox3D";

    /** The 3D position and orientation of the bounding box center */
    public PoseMessage center = new PoseMessage();

    /** The size of the bounding box, in meters, surrounding the object's center pose. */
    public Vector3Message size = new Vector3Message();

    public BoundingBox3DMessage withCenter(PoseMessage center) {
        this.center = center;
        return this;
    }

    public BoundingBox3DMessage withSize(Vector3Message size) {
        this.size = size;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, size);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (BoundingBox3DMessage) obj;
        return Objects.equals(center, other.center) && Objects.equals(size, other.size);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "center", center,
                "size", size);
    }
}
