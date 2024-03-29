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
 * Definition for geometry_msgs/AccelWithCovariance This expresses acceleration in free space with
 * uncertainty.
 */
@MessageMetadata(
        name = AccelWithCovarianceMessage.NAME,
        fields = {"accel", "covariance"},
        md5sum = "ad5a718d699c6be72a02b8d6a139f334")
public class AccelWithCovarianceMessage implements Message {

    static final String NAME = "geometry_msgs/AccelWithCovariance";

    public AccelMessage accel = new AccelMessage();

    /**
     * Row-major representation of the 6x6 covariance matrix The orientation parameters use a
     * fixed-axis representation. In order, the parameters are: (x, y, z, rotation about X axis,
     * rotation about Y axis, rotation about Z axis)
     */
    @Array(size = 36)
    public double[] covariance = new double[0];

    public AccelWithCovarianceMessage withAccel(AccelMessage accel) {
        this.accel = accel;
        return this;
    }

    public AccelWithCovarianceMessage withCovariance(double... covariance) {
        Preconditions.equals(36, covariance.length);
        this.covariance = covariance;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accel, Arrays.hashCode(covariance));
    }

    @Override
    public boolean equals(Object obj) {
        var other = (AccelWithCovarianceMessage) obj;
        return Objects.equals(accel, other.accel) && Arrays.equals(covariance, other.covariance);
    }

    @Override
    public String toString() {
        return XJson.asString("accel", accel, "covariance", Arrays.toString(covariance));
    }
}
