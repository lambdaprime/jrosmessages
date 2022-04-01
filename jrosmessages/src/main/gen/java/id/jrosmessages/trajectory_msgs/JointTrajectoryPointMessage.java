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
import id.jrosmessages.primitives.Duration;
import id.kineticstreamer.annotations.Streamed;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/**
 * Definition for trajectory_msgs/JointTrajectoryPoint Each trajectory point specifies either
 * positions[, velocities[, accelerations]] # or positions[, effort] for the trajectory to be
 * executed. # All specified values are in the same order as the joint names in JointTrajectory.msg
 */
@MessageMetadata(
        type = JointTrajectoryPointMessage.NAME,
        md5sum = "0b7b3d8dcc88390331fe8287246f673f")
public class JointTrajectoryPointMessage implements Message {

    static final String NAME = "trajectory_msgs/JointTrajectoryPoint";

    @Streamed public double[] positions = new double[0];

    @Streamed public double[] velocities = new double[0];

    @Streamed public double[] accelerations = new double[0];

    @Streamed public double[] effort = new double[0];

    @Streamed public Duration time_from_start = new Duration();

    public JointTrajectoryPointMessage withPositions(double... positions) {
        this.positions = positions;
        return this;
    }

    public JointTrajectoryPointMessage withVelocities(double... velocities) {
        this.velocities = velocities;
        return this;
    }

    public JointTrajectoryPointMessage withAccelerations(double... accelerations) {
        this.accelerations = accelerations;
        return this;
    }

    public JointTrajectoryPointMessage withEffort(double... effort) {
        this.effort = effort;
        return this;
    }

    public JointTrajectoryPointMessage withTimeFromStart(Duration time_from_start) {
        this.time_from_start = time_from_start;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                Arrays.hashCode(positions),
                Arrays.hashCode(velocities),
                Arrays.hashCode(accelerations),
                Arrays.hashCode(effort),
                time_from_start);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (JointTrajectoryPointMessage) obj;
        return Arrays.equals(positions, other.positions)
                && Arrays.equals(velocities, other.velocities)
                && Arrays.equals(accelerations, other.accelerations)
                && Arrays.equals(effort, other.effort)
                && Objects.equals(time_from_start, other.time_from_start);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "positions", positions,
                "velocities", velocities,
                "accelerations", accelerations,
                "effort", effort,
                "time_from_start", time_from_start);
    }
}
