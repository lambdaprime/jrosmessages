/*
 * Copyright 2022 jrosmessages project
 *
 * Website: https://github.com/lambdaprime/jrosmessages
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
/**
 * Java module with ROS (Robot Operating System) message definitions. These message definitions are
 * currently used in <a href="https://github.com/lambdaprime/jrosclient">jrosclient</a> but they are
 * independent from it and can be used in other Java projects too.
 *
 * <p>By default every message in this module implements toString method which returns ROS message
 * representation in JSON format (including all its values).
 *
 * @see <a href= "http://portal2.atwebpages.com/jrosclient/Defining_messages.html">Defining new
 *     messages</a>
 * @see <a href= "https://github.com/lambdaprime/jrosmessages/releases">Download</a>
 * @see <a href="https://github.com/lambdaprime/jrosmessages">GitHub repository</a>
 * @see <a href= "http://portal2.atwebpages.com/jrosclient/">jrosclient documentation</a> * @author
 *     lambdaprime intid@protonmail.com
 */
module jrosmessages {
    requires id.xfunction;
    requires id.kineticstreamer;
    requires java.logging;

    exports id.jrosmessages;
    exports id.jrosmessages.primitives;
    exports id.jrosmessages.std_msgs;
    exports id.jrosmessages.geometry_msgs;
    exports id.jrosmessages.sensor_msgs;
    exports id.jrosmessages.trajectory_msgs;
    exports id.jrosmessages.shape_msgs;
    exports id.jrosmessages.object_recognition_msgs;
}
