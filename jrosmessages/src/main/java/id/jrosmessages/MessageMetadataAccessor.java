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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Allows to access {@link Message} metadata based on their {@link Class} object. Must be
 * thread-safe.
 *
 * @author lambdaprime intid@protonmail.com
 */
public class MessageMetadataAccessor {

    public String getMd5(Class<? extends Message> messageClass) {
        return Optional.ofNullable(messageClass.getAnnotation(MessageMetadata.class))
                .map(MessageMetadata::md5sum)
                .filter(Predicate.not(String::isEmpty))
                .orElseThrow(
                        () ->
                                new XRE(
                                        "Metadata 'md5sum' property is missing for %s",
                                        messageClass));
    }

    public String getName(Class<? extends Message> messageClass) {
        return Optional.ofNullable(messageClass.getAnnotation(MessageMetadata.class))
                .map(MessageMetadata::name)
                .orElseThrow(
                        () -> new XRE("Metadata 'name' property is missing for %s", messageClass));
    }

    public RosInterfaceType getInterfaceType(Class<? extends Message> messageClass) {
        return Optional.ofNullable(messageClass.getAnnotation(MessageMetadata.class))
                .map(MessageMetadata::interfaceType)
                .orElseThrow(
                        () ->
                                new XRE(
                                        "Metadata 'interfaceType' property is missing for %s",
                                        messageClass));
    }

    public List<String> getFields(Class<? extends Message> messageClass) {
        return Optional.ofNullable(messageClass.getAnnotation(MessageMetadata.class))
                .map(MessageMetadata::fields)
                .map(Arrays::asList)
                .orElseThrow(
                        () ->
                                new XRE(
                                        "Metadata 'fields' property is missing for %s",
                                        messageClass));
    }
}
