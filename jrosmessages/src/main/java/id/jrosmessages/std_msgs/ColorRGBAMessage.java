/*
 * Copyright 2022 jrosclient project
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
package id.jrosmessages.std_msgs;

import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.xfunction.XJson;
import java.util.Objects;

/** Definition for std_msgs/ColorRGBA */
@MessageMetadata(name = ColorRGBAMessage.NAME, md5sum = "a29a96539573343b1310c73607334b00")
public class ColorRGBAMessage implements Message {

    static final String NAME = "std_msgs/ColorRGBA";

    public static final ColorRGBAMessage RED = new ColorRGBAMessage(0.F, 1.F, 0.F, 1.F);

    public float r, g, b, a;

    public ColorRGBAMessage() {
        // TODO Auto-generated constructor stub
    }

    public ColorRGBAMessage(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public ColorRGBAMessage withR(float r) {
        this.r = r;
        return this;
    }

    public ColorRGBAMessage withG(float g) {
        this.g = g;
        return this;
    }

    public ColorRGBAMessage withB(float b) {
        this.b = b;
        return this;
    }

    public ColorRGBAMessage withA(float a) {
        this.a = a;
        return this;
    }

    @Override
    public String toString() {
        return XJson.asString("r", r, "g", g, "b", b, "a", a).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, g, b, a);
    }

    @Override
    public boolean equals(Object obj) {
        ColorRGBAMessage other = (ColorRGBAMessage) obj;
        return Objects.equals(r, other.r)
                && Objects.equals(g, other.g)
                && Objects.equals(b, other.b)
                && Objects.equals(a, other.a);
    }
}
