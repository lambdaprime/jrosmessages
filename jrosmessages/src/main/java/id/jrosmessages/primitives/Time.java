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
package id.jrosmessages.primitives;

import id.jrosmessages.MessageMetadata;
import id.xfunction.XJson;
import java.time.Instant;

/**
 * @author lambdaprime intid@protonmail.com
 */
@MessageMetadata(
        name = "Time",
        fields = {"sec", "nsec"})
public class Time {

    /** Seconds (stamp_secs) since epoch (unsigned) */
    public int sec;

    /** Nanoseconds since this.sec (unsigned) */
    public int nsec;

    public Time() {}

    public Time(int sec, int nsec) {
        this.sec = sec;
        this.nsec = nsec;
    }

    @Override
    public String toString() {
        return XJson.asString(
                        "sec",
                        Integer.toUnsignedString(sec),
                        "nsec",
                        Integer.toUnsignedString(nsec))
                .toString();
    }

    @Override
    public int hashCode() {
        return sec + nsec;
    }

    @Override
    public boolean equals(Object obj) {
        Time other = (Time) obj;
        return sec == other.sec && nsec == other.nsec;
    }

    public static Time now() {
        var now = Instant.now();
        return new Time((int) now.getEpochSecond(), now.getNano());
    }
}
