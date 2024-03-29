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
package id.jrosmessages.object_recognition_msgs;

import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.XJson;
import java.util.Objects;

/**
 * Definition for object_recognition_msgs/ObjectType
 * ################################################# OBJECT ID
 * #########################################################
 */
@MessageMetadata(
        name = ObjectTypeMessage.NAME,
        fields = {"key", "db"},
        md5sum = "ac757ec5be1998b0167e7efcda79e3cf")
public class ObjectTypeMessage implements Message {

    static final String NAME = "object_recognition_msgs/ObjectType";

    /**
     * Contains information about the type of a found object. Those two sets of parameters together
     * uniquely define an object The key of the found object: the unique identifier in the given db
     */
    public StringMessage key = new StringMessage();

    /**
     * The db parameters stored as a JSON/compressed YAML string. An object id does not make sense
     * without the corresponding database. E.g., in object_recognition, it can look like:
     * "{'type':'CouchDB', 'root':'http://localhost'}" There is no conventional format for those
     * parameters and it's nice to keep that flexibility. The object_recognition_core as a generic
     * DB type that can read those fields Current examples: For CouchDB: type: 'CouchDB' root:
     * 'http://localhost:5984' collection: 'object_recognition' For SQL household database: type:
     * 'SqlHousehold' host: 'wgs36' port: 5432 user: 'willow' password: 'willow' name:
     * 'household_objects' module: 'tabletop'
     */
    public StringMessage db = new StringMessage();

    public ObjectTypeMessage withKey(StringMessage key) {
        this.key = key;
        return this;
    }

    public ObjectTypeMessage withDb(StringMessage db) {
        this.db = db;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, db);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (ObjectTypeMessage) obj;
        return Objects.equals(key, other.key) && Objects.equals(db, other.db);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "key", key,
                "db", db);
    }
}
