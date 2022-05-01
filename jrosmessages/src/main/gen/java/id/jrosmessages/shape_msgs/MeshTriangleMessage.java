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
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/** Definition for shape_msgs/MeshTriangle */
@MessageMetadata(name = MeshTriangleMessage.NAME, md5sum = "9f61477ed8ee061cb6d71555c375ad8f")
public class MeshTriangleMessage implements Message {

    static final String NAME = "shape_msgs/MeshTriangle";

    /** Definition of a triangle's vertices */
    public int[] vertex_indices = new int[0];

    public MeshTriangleMessage withVertexIndices(int... vertex_indices) {
        this.vertex_indices = vertex_indices;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(vertex_indices));
    }

    @Override
    public boolean equals(Object obj) {
        var other = (MeshTriangleMessage) obj;
        return Arrays.equals(vertex_indices, other.vertex_indices);
    }

    @Override
    public String toString() {
        return XJson.asString("vertex_indices", vertex_indices);
    }
}
