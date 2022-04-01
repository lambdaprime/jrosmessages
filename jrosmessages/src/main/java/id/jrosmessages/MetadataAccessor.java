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

import id.xfunction.lang.XRE;
import java.util.Optional;

/** Allows to access message metadata based on their class object. */
public class MetadataAccessor {

    public String getMd5(Class<? extends Message> messageClass) {
        return Optional.ofNullable(messageClass.getAnnotation(MessageMetadata.class))
                .map(MessageMetadata::md5sum)
                .orElseThrow(() -> new XRE("Metadata is missing for %s", messageClass));
    }

    public String getType(Class<? extends Message> messageClass) {
        return Optional.ofNullable(messageClass.getAnnotation(MessageMetadata.class))
                .map(MessageMetadata::type)
                .orElseThrow(() -> new XRE("Metadata is missing for %s", messageClass));
    }
}
