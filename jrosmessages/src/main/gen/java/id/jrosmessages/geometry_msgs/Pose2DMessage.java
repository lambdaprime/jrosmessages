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
 * Definition for geometry_msgs/Pose2D Deprecated # Please use the full 3D pose.
 *
 * <p># In general our recommendation is to use a full 3D representation of everything and for 2D
 * specific applications make the appropriate projections into the plane for their calculations but
 * optimally will preserve the 3D information during processing.
 *
 * <p># If we have parallel copies of 2D datatypes every UI and other pipeline will end up needing
 * to have dual interfaces to plot everything. And you will end up with not being able to use 3D
 * tools for 2D use cases even if they're completely valid, as you'd have to reimplement it with
 * different inputs and outputs. It's not particularly hard to plot the 2D pose or compute the yaw
 * error for the Pose message and there are already tools and libraries that can do this for you.
 *
 * <p># This expresses a position and orientation on a 2D manifold.
 */
@MessageMetadata(
        name = Pose2DMessage.NAME,
        fields = {"x", "y", "theta"},
        md5sum = "938fa65709584ad8e77d238529be13b8")
public class Pose2DMessage implements Message {

    static final String NAME = "geometry_msgs/Pose2D";

    public double x;

    public double y;

    public double theta;

    public Pose2DMessage withX(double x) {
        this.x = x;
        return this;
    }

    public Pose2DMessage withY(double y) {
        this.y = y;
        return this;
    }

    public Pose2DMessage withTheta(double theta) {
        this.theta = theta;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, theta);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (Pose2DMessage) obj;
        return x == other.x && y == other.y && theta == other.theta;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "x", x,
                "y", y,
                "theta", theta);
    }
}
