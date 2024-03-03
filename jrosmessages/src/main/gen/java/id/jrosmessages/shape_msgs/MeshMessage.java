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

import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.geometry_msgs.PointMessage;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/**
 * Definition for shape_msgs/Mesh
 *
 * <p>Definition of a mesh
 */
@MessageMetadata(
        name = MeshMessage.NAME,
        fields = {"triangles", "vertices"},
        md5sum = "1ffdae9486cd3316a121c578b47a85cc")
public class MeshMessage implements Message {

    static final String NAME = "shape_msgs/Mesh";

    /** list of triangles; the index values refer to positions in vertices[] */
    public MeshTriangleMessage[] triangles = new MeshTriangleMessage[0];

    /** the actual vertices that make up the mesh */
    public PointMessage[] vertices = new PointMessage[0];

    public MeshMessage withTriangles(MeshTriangleMessage... triangles) {
        this.triangles = triangles;
        return this;
    }

    public MeshMessage withVertices(PointMessage... vertices) {
        this.vertices = vertices;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(triangles), Arrays.hashCode(vertices));
    }

    @Override
    public boolean equals(Object obj) {
        var other = (MeshMessage) obj;
        return Arrays.equals(triangles, other.triangles) && Arrays.equals(vertices, other.vertices);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "triangles", triangles,
                "vertices", vertices);
    }
}
