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

import id.jrosmessages.Array;
import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.xfunction.Preconditions;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/**
 * Definition for geometry_msgs/TwistWithCovariance This expresses velocity in free space with
 * uncertainty.
 */
@MessageMetadata(
        name = TwistWithCovarianceMessage.NAME,
        md5sum = "408e7ef4f4ec295f4663586922faacdd")
public class TwistWithCovarianceMessage implements Message {

    static final String NAME = "geometry_msgs/TwistWithCovariance";

    public TwistMessage twist = new TwistMessage();

    /**
     * Row-major representation of the 6x6 covariance matrix The orientation parameters use a
     * fixed-axis representation. In order, the parameters are: (x, y, z, rotation about X axis,
     * rotation about Y axis, rotation about Z axis)
     */
    @Array(size = 36)
    public double[] covariance = new double[0];

    public TwistWithCovarianceMessage withTwist(TwistMessage twist) {
        this.twist = twist;
        return this;
    }

    public TwistWithCovarianceMessage withCovariance(double... covariance) {
        Preconditions.equals(36, covariance.length);
        this.covariance = covariance;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(twist, Arrays.hashCode(covariance));
    }

    @Override
    public boolean equals(Object obj) {
        var other = (TwistWithCovarianceMessage) obj;
        return Objects.equals(twist, other.twist) && Arrays.equals(covariance, other.covariance);
    }

    @Override
    public String toString() {
        return XJson.asString("twist", twist, "covariance", Arrays.toString(covariance));
    }
}
