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
 * Definition for geometry_msgs/Accel This expresses acceleration in free space broken into its
 * linear and angular parts.
 */
@MessageMetadata(
        name = AccelMessage.NAME,
        fields = {"linear", "angular"},
        md5sum = "9f195f881246fdfa2798d1d3eebca84a")
public class AccelMessage implements Message {

    static final String NAME = "geometry_msgs/Accel";

    public Vector3Message linear = new Vector3Message();

    public Vector3Message angular = new Vector3Message();

    public AccelMessage withLinear(Vector3Message linear) {
        this.linear = linear;
        return this;
    }

    public AccelMessage withAngular(Vector3Message angular) {
        this.angular = angular;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linear, angular);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (AccelMessage) obj;
        return Objects.equals(linear, other.linear) && Objects.equals(angular, other.angular);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "linear", linear,
                "angular", angular);
    }
}
