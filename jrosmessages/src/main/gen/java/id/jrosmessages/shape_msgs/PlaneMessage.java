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
package id.jrosmessages.shape_msgs;

import id.jrosmessages.Array;
import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.xfunction.Preconditions;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/**
 * Definition for shape_msgs/Plane Representation of a plane, using the plane equation ax + by + cz
 * + d = 0
 */
@MessageMetadata(name = PlaneMessage.NAME, md5sum = "fc4d6d85ce294ff40862d9c7e9556367")
public class PlaneMessage implements Message {

    static final String NAME = "shape_msgs/Plane";

    /** a := coef[0] b := coef[1] c := coef[2] d := coef[3] */
    @Array(size = 4)
    public double[] coef = new double[0];

    public PlaneMessage withCoef(double... coef) {
        Preconditions.equals(4, coef.length);
        this.coef = coef;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(coef));
    }

    @Override
    public boolean equals(Object obj) {
        var other = (PlaneMessage) obj;
        return Arrays.equals(coef, other.coef);
    }

    @Override
    public String toString() {
        return XJson.asString("coef", coef);
    }
}
