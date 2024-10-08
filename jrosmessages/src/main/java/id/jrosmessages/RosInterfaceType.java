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

/**
 * ROS applications typically communicate through interfaces of one of three types: messages,
 * services and actions.
 *
 * @author lambdaprime intid@protonmail.com
 * @see <a href="https://docs.ros.org/en/galactic/Concepts/About-ROS-Interfaces.html">About ROS
 *     Interfaces</a>
 */
public enum RosInterfaceType {
    MESSAGE,
    SERVICE,
    ACTION
}
