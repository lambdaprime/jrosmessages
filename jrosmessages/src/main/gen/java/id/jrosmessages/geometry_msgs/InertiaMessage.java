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

/** Definition for geometry_msgs/Inertia */
@MessageMetadata(
        name = InertiaMessage.NAME,
        fields = {"m", "com", "ixx", "ixy", "ixz", "iyy", "iyz", "izz"},
        md5sum = "1d26e4bb6c83ff141c5cf0d883c2b0fe")
public class InertiaMessage implements Message {

    static final String NAME = "geometry_msgs/Inertia";

    /** Mass [kg] */
    public double m;

    /** Center of mass [m] */
    public Vector3Message com = new Vector3Message();

    /** Inertia Tensor [kg-m^2] | ixx ixy ixz | I = | ixy iyy iyz | | ixz iyz izz | */
    public double ixx;

    public double ixy;

    public double ixz;

    public double iyy;

    public double iyz;

    public double izz;

    public InertiaMessage withM(double m) {
        this.m = m;
        return this;
    }

    public InertiaMessage withCom(Vector3Message com) {
        this.com = com;
        return this;
    }

    public InertiaMessage withIxx(double ixx) {
        this.ixx = ixx;
        return this;
    }

    public InertiaMessage withIxy(double ixy) {
        this.ixy = ixy;
        return this;
    }

    public InertiaMessage withIxz(double ixz) {
        this.ixz = ixz;
        return this;
    }

    public InertiaMessage withIyy(double iyy) {
        this.iyy = iyy;
        return this;
    }

    public InertiaMessage withIyz(double iyz) {
        this.iyz = iyz;
        return this;
    }

    public InertiaMessage withIzz(double izz) {
        this.izz = izz;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m, com, ixx, ixy, ixz, iyy, iyz, izz);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (InertiaMessage) obj;
        return m == other.m
                && Objects.equals(com, other.com)
                && ixx == other.ixx
                && ixy == other.ixy
                && ixz == other.ixz
                && iyy == other.iyy
                && iyz == other.iyz
                && izz == other.izz;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "m", m,
                "com", com,
                "ixx", ixx,
                "ixy", ixy,
                "ixz", ixz,
                "iyy", iyy,
                "iyz", iyz,
                "izz", izz);
    }
}
