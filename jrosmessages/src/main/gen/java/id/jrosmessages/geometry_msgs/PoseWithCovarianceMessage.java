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
import id.kineticstreamer.annotations.Streamed;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/**
 * Definition for geometry_msgs/PoseWithCovariance This represents a pose in free space with
 * uncertainty.
 */
@MessageMetadata(type = PoseWithCovarianceMessage.NAME, md5sum = "4ec31161b30291389f54fb885685270a")
public class PoseWithCovarianceMessage implements Message {

    static final String NAME = "geometry_msgs/PoseWithCovariance";

    @Streamed public PoseMessage pose = new PoseMessage();

    /**
     * Row-major representation of the 6x6 covariance matrix The orientation parameters use a
     * fixed-axis representation. In order, the parameters are: (x, y, z, rotation about X axis,
     * rotation about Y axis, rotation about Z axis)
     */
    @Streamed public double[] covariance = new double[0];

    public PoseWithCovarianceMessage withPose(PoseMessage pose) {
        this.pose = pose;
        return this;
    }

    public PoseWithCovarianceMessage withCovariance(double... covariance) {
        this.covariance = covariance;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pose, Arrays.hashCode(covariance));
    }

    @Override
    public boolean equals(Object obj) {
        var other = (PoseWithCovarianceMessage) obj;
        return Objects.equals(pose, other.pose) && Arrays.equals(covariance, other.covariance);
    }

    @Override
    public String toString() {
        return XJson.asString("pose", pose, "covariance", Arrays.toString(covariance));
    }
}
