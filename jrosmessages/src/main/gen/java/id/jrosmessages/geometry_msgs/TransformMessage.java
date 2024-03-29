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
 * Definition for geometry_msgs/Transform This represents the transform between two coordinate
 * frames in free space.
 */
@MessageMetadata(
        name = TransformMessage.NAME,
        fields = {"translation", "rotation"},
        md5sum = "ac9eff44abf714214112b05d54a3cf9b")
public class TransformMessage implements Message {

    static final String NAME = "geometry_msgs/Transform";

    public Vector3Message translation = new Vector3Message();

    public QuaternionMessage rotation = new QuaternionMessage();

    public TransformMessage withTranslation(Vector3Message translation) {
        this.translation = translation;
        return this;
    }

    public TransformMessage withRotation(QuaternionMessage rotation) {
        this.rotation = rotation;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(translation, rotation);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (TransformMessage) obj;
        return Objects.equals(translation, other.translation)
                && Objects.equals(rotation, other.rotation);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "translation", translation,
                "rotation", rotation);
    }
}
