/*
 * Copyright 2023 jrosclient project
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

/**
 * List of metrics emitted by <b>jrosclient</b> during ROS message processing.
 *
 * @author lambdaprime intid@protonmail.com
 */
public interface JRosMessageMetrics {

    String MESSAGE_SERIALIZATION_TIME_METRIC = "message_serialize_time_ms";
    String MESSAGE_SERIALIZATION_TIME_METRIC_DESCRIPTION =
            "ROS message serialization time in millis";

    String MESSAGE_DESERIALIZATION_TIME_METRIC = "message_deserialize_time_ms";
    String MESSAGE_DESERIALIZATION_TIME_METRIC_DESCRIPTION =
            "ROS message deserialization time in millis";
}
