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
package id.jrosmessages;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Every Message object suppose to contain message data only and not its metadata.
 *
 * <p>That is why there is no metadata methods in base {@link Message} interface. Doing so we would
 * couple both and so to see the metadata for any message we would have to create a Message object
 * first.
 *
 * <p>Using this annotation on other hand allows to keep all Message metadata in its {@link Class}
 * object and access it right from there avoiding unnecessary Message object instantiation.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MessageMetadata {

    /**
     * ROS message name.
     *
     * <p>For example: std_msgs/String
     */
    String name();

    /**
     * If ROS message consist from more than one field then they all should be listed inside this
     * parameter in the same order as they declared inside the ROS message (and this is also the
     * order in which they will be (de)serialized).
     *
     * <p>For example:
     *
     * <ul>
     *   <li>in std_msgs/String there is only one field "data" so this parameter is no required
     *   <li>in std_msgs/ColorRGBA there are four fields: "r", "g", "b", "a" so this parameter
     *       should be initialized like fields = {"r", "g", "b", "a"}
     * </ul>
     */
    String[] fields() default {};

    /**
     * ROS1 MD5 sum of the message. For example for message type "std_msgs/String" you can calculate
     * it using rosmsg command:
     *
     * <pre>
     * rosmsg md5 std_msgs/String
     * </pre>
     *
     * <p>It is required in ROS1 and is optional (ignored) in ROS2 messages.
     */
    String md5sum() default "";

    RosInterfaceType interfaceType() default RosInterfaceType.MESSAGE;
}
