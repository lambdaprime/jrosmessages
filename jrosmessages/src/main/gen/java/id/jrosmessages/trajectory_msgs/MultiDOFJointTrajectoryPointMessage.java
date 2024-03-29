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
package id.jrosmessages.trajectory_msgs;

import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.geometry_msgs.TransformMessage;
import id.jrosmessages.geometry_msgs.TwistMessage;
import id.jrosmessages.primitives.Duration;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/** Definition for trajectory_msgs/MultiDOFJointTrajectoryPoint */
@MessageMetadata(
        name = MultiDOFJointTrajectoryPointMessage.NAME,
        fields = {"transforms", "velocities", "accelerations", "time_from_start"},
        md5sum = "3ebe08d1abd5b65862d50e09430db776")
public class MultiDOFJointTrajectoryPointMessage implements Message {

    static final String NAME = "trajectory_msgs/MultiDOFJointTrajectoryPoint";

    /** Each multi-dof joint can specify a transform (up to 6 DOF) */
    public TransformMessage[] transforms = new TransformMessage[0];

    /** There can be a velocity specified for the origin of the joint */
    public TwistMessage[] velocities = new TwistMessage[0];

    /** There can be an acceleration specified for the origin of the joint */
    public TwistMessage[] accelerations = new TwistMessage[0];

    public Duration time_from_start = new Duration();

    public MultiDOFJointTrajectoryPointMessage withTransforms(TransformMessage... transforms) {
        this.transforms = transforms;
        return this;
    }

    public MultiDOFJointTrajectoryPointMessage withVelocities(TwistMessage... velocities) {
        this.velocities = velocities;
        return this;
    }

    public MultiDOFJointTrajectoryPointMessage withAccelerations(TwistMessage... accelerations) {
        this.accelerations = accelerations;
        return this;
    }

    public MultiDOFJointTrajectoryPointMessage withTimeFromStart(Duration time_from_start) {
        this.time_from_start = time_from_start;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                Arrays.hashCode(transforms),
                Arrays.hashCode(velocities),
                Arrays.hashCode(accelerations),
                time_from_start);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (MultiDOFJointTrajectoryPointMessage) obj;
        return Arrays.equals(transforms, other.transforms)
                && Arrays.equals(velocities, other.velocities)
                && Arrays.equals(accelerations, other.accelerations)
                && Objects.equals(time_from_start, other.time_from_start);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "transforms", transforms,
                "velocities", velocities,
                "accelerations", accelerations,
                "time_from_start", time_from_start);
    }
}
