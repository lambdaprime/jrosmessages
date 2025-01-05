/*
 * Copyright 2025 jrosclient project
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

import id.jroscommon.RosName;
import id.xfunction.Preconditions;
import id.xfunction.lang.XRE;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Describe {@link Message} class with its metadata.
 *
 * <p>Can be used to dynamically override metadata of message classes. Ideally all message metadata
 * should be statically defined with {@link MessageMetadata}. But in certain rare cases it may be
 * needed to define such metadata dynamically.
 *
 * <p>Must be thread-safe.
 *
 * @author lambdaprime intid@protonmail.com
 */
public class MessageDescriptor<M extends Message> {
    private final Class<M> messageClass;
    private final MessageMetadata metadata;

    private MessageDescriptor(Class<M> messageClass, MessageMetadata metadata) {
        Preconditions.notNull(metadata, "No metadata for Message class %s", messageClass);
        this.messageClass = messageClass;
        this.metadata = metadata;
    }

    public MessageDescriptor(Class<M> messageClass) {
        this(messageClass, messageClass.getAnnotation(MessageMetadata.class));
    }

    public Class<M> getMessageClass() {
        return messageClass;
    }

    public String readMd5() {
        return Optional.ofNullable(metadata.md5sum())
                .filter(Predicate.not(String::isEmpty))
                .orElseThrow(
                        () ->
                                new XRE(
                                        "Metadata 'md5sum' property is missing or empty for %s",
                                        messageClass));
    }

    public RosName readName() {
        return Optional.ofNullable(metadata.name())
                .map(RosName::ofPackageResourceName)
                .orElseThrow(
                        () ->
                                new XRE(
                                        "Metadata 'name' property is missing or empty for %s",
                                        messageClass));
    }

    public String readNameRaw() {
        return Optional.ofNullable(metadata.name())
                .orElseThrow(
                        () -> new XRE("Metadata 'name' property is missing for %s", messageClass));
    }

    public RosInterfaceType readInterfaceType() {
        return Optional.ofNullable(metadata.interfaceType())
                .orElseThrow(
                        () ->
                                new XRE(
                                        "Metadata 'interfaceType' property is missing for %s",
                                        messageClass));
    }

    public List<String> readFields() {
        return Optional.ofNullable(metadata.fields())
                .map(Arrays::asList)
                .orElseThrow(
                        () ->
                                new XRE(
                                        "Metadata 'fields' property is missing for %s",
                                        messageClass));
    }
}
