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
package id.jrosmessages.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import id.jrosmessages.MessageFormat;
import id.jrosmessages.geometry_msgs.Point32Message;
import id.jrosmessages.geometry_msgs.PointMessage;
import id.jrosmessages.geometry_msgs.PoseMessage;
import id.jrosmessages.geometry_msgs.QuaternionMessage;
import id.jrosmessages.geometry_msgs.Vector3Message;
import id.jrosmessages.impl.RosDataInput;
import id.jrosmessages.impl.RosDataOutput;
import id.jrosmessages.std_msgs.ColorRGBAMessage;
import id.jrosmessages.std_msgs.StringMessage;
import id.kineticstreamer.KineticStreamReader;
import id.kineticstreamer.KineticStreamWriter;
import id.xfunction.ResourceUtils;
import id.xfunction.io.XInputStream;
import id.xfunction.io.XOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MessageTests {
    private static final ResourceUtils resourceUtils = new ResourceUtils();

    static Stream<List> dataProvider() {
        return Stream.of(
                List.of(
                        resourceUtils.readResource(MessageTests.class, "string-empty"),
                        new StringMessage()),
                List.of(
                        resourceUtils.readResource(MessageTests.class, "string-ros2"),
                        new StringMessage("Hello World: 2767"),
                        MessageFormat.ROS2),
                List.of(
                        resourceUtils.readResource(MessageTests.class, "string-empty-ros2"),
                        new StringMessage(),
                        MessageFormat.ROS2),
                List.of(
                        resourceUtils.readResource(MessageTests.class, "string"),
                        new StringMessage().withData("hello there")),
                List.of(
                        resourceUtils.readResource(MessageTests.class, "point-empty"),
                        new PointMessage()),
                List.of(
                        resourceUtils.readResource(MessageTests.class, "point"),
                        new PointMessage().withX(1.0).withY(1.0).withZ(1.0)),
                List.of(
                        resourceUtils.readResource(MessageTests.class, "point32"),
                        new Point32Message().withX(1.0F).withY(1.0F).withZ(1.0F)),
                List.of(
                        resourceUtils.readResource(MessageTests.class, "quaternion-empty"),
                        new QuaternionMessage()),
                List.of(
                        resourceUtils.readResource(MessageTests.class, "quaternion"),
                        new QuaternionMessage().withX(1.0).withY(1.0).withZ(1.0).withW(3.0)),
                List.of(
                        resourceUtils.readResource(MessageTests.class, "pose-empty"),
                        new PoseMessage()),
                List.of(
                        resourceUtils.readResource(MessageTests.class, "pose"),
                        new PoseMessage()
                                .withPosition(new PointMessage().withX(1.0).withY(1.0).withZ(1.0))
                                .withQuaternion(
                                        new QuaternionMessage()
                                                .withX(1.0)
                                                .withY(1.0)
                                                .withZ(1.0)
                                                .withW(3.0))),
                List.of(
                        resourceUtils.readResource(MessageTests.class, "colorrgba-empty"),
                        new ColorRGBAMessage()),
                List.of(
                        resourceUtils.readResource(MessageTests.class, "colorrgba"),
                        new ColorRGBAMessage().withR(.12F).withG(.13F).withB(.14F).withA(.15F)),
                List.of(
                        resourceUtils.readResource(MessageTests.class, "vector3-empty"),
                        new Vector3Message()),
                List.of(
                        resourceUtils.readResource(MessageTests.class, "vector3"),
                        new Vector3Message().withX(.12).withY(.13).withZ(.14)));
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testRead(List testData) throws Exception {
        var collector = new XInputStream((String) testData.get(0));
        var dis = new RosDataInput(new DataInputStream(collector));
        if (testData.size() == 3)
            dis = new RosDataInput(new DataInputStream(collector), (MessageFormat) testData.get(2));
        var ks = new KineticStreamReader(dis);
        Object expected = testData.get(1);
        Object actual = ks.read(expected.getClass());
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testWrite(List testData) throws Exception {
        var b = testData.get(1);
        var collector = new XOutputStream();
        var dos = new RosDataOutput(new DataOutputStream(collector));
        if (testData.size() == 3)
            dos =
                    new RosDataOutput(
                            new DataOutputStream(collector), (MessageFormat) testData.get(2));
        var ks = new KineticStreamWriter(dos);
        ks.write(b);
        assertEquals(testData.get(0), collector.asHexString());
    }
}
