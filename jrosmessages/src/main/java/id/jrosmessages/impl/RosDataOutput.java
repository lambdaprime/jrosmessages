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
package id.jrosmessages.impl;

import id.jrosmessages.MessageFormat;
import id.kineticstreamer.KineticStreamWriter;
import id.kineticstreamer.OutputKineticStream;
import java.io.DataOutput;
import java.io.IOException;

public class RosDataOutput implements OutputKineticStream {

    private DataOutput out;
    private MessageFormat messageFormat;

    public RosDataOutput(DataOutput out) {
        this(out, MessageFormat.ROS1);
    }

    public RosDataOutput(DataOutput out, MessageFormat messageFormat) {
        this.out = out;
        this.messageFormat = messageFormat;
    }

    public void writeLen(int len) throws IOException {
        out.writeInt(Integer.reverseBytes(len));
    }

    @Override
    public void writeString(String str) throws IOException {
        var len = str.length();
        if (messageFormat == MessageFormat.ROS2 && !str.isEmpty()) len++;
        writeLen(len);
        out.write(str.getBytes());
        if (messageFormat == MessageFormat.ROS2 && len != 0) out.write(0);
    }

    @Override
    public void writeInt(Integer i) throws IOException {
        out.writeInt(Integer.reverseBytes(i));
    }

    @Override
    public void writeDouble(Double f) throws IOException {
        out.writeDouble(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(f))));
    }

    @Override
    public void writeFloat(Float f) throws IOException {
        out.writeFloat(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f))));
    }

    @Override
    public void writeBoolean(Boolean b) throws IOException {
        out.writeBoolean(b);
    }

    @Override
    public void writeArray(Object[] array) throws Exception {
        writeLen(array.length);
        for (var item : array) {
            new KineticStreamWriter(this).write(item);
        }
    }

    @Override
    public void close() throws Exception {
        // nothing to release
    }

    @Override
    public void writeByte(Byte b) throws Exception {
        out.writeByte(b);
    }

    @Override
    public void writeIntArray(int[] array) throws Exception {
        throw new RuntimeException("Not supported");
    }

    @Override
    public void writeByteArray(byte[] array) throws Exception {
        writeLen(array.length);
        for (var item : array) {
            out.writeByte(item);
        }
    }

    @Override
    public void writeDoubleArray(double[] array) throws Exception {
        writeLen(array.length);
        for (var item : array) {
            writeDouble(item);
        }
    }

    @Override
    public void writeBooleanArray(boolean[] array) throws Exception {
        writeLen(array.length);
        for (var item : array) {
            writeBoolean(item);
        }
    }
}
