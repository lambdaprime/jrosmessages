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

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertEquals;

import id.jrosmessages.Message;
import id.jrosmessages.impl.AbstractMessageSerializationUtils;
import id.xfunction.ResourceUtils;
import id.xfunction.XByte;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Required dataProvider method to be defined in subclasses:
 *
 * <pre>{@code
 * static Stream<TestCase> dataProvider() {
 *      return Stream.of(new TestCase(...));
 * }
 * }</pre>
 *
 * @author lambdaprime intid@protonmail.com
 */
@Nested
public abstract class MessageTests {

    public record TestCase(String resourceName, Message message) {}

    private static final ResourceUtils resourceUtils = new ResourceUtils();
    private AbstractMessageSerializationUtils serializationUtils;

    public MessageTests(AbstractMessageSerializationUtils serializationUtils) {
        this.serializationUtils = serializationUtils;
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testRead(TestCase testCase) throws Exception {
        var bytes = readResource(testCase.resourceName());
        Object actual =
                serializationUtils.read(XByte.fromHexPairs(bytes), testCase.message.getClass());
        System.out.println(actual);
        assertEquals(testCase.message, actual);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testWrite(TestCase testCase) throws Exception {
        var out = serializationUtils.write(testCase.message);
        assertEquals(readResource(testCase.resourceName()), XByte.toHexPairs(out));
    }

    /** Read resource removing new lines if any */
    private String readResource(String resourceName) {
        var resource =
                resourceUtils
                        .readResourceAsStream(getClass(), resourceName)
                        .filter(s -> !s.isBlank())
                        .collect(joining(" "));
        return resource;
    }
}
