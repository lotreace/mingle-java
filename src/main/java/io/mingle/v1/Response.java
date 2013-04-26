/* Copyright 2013 Cezar Lotrean

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package io.mingle.v1;

import org.json.simple.*;

public final class Response {
    private final Object obj;

    public Response(Object obj) {
        this.obj = obj;
    }

    public String value() {
        if (obj == null)
            return "";

        return obj.toString();
    }

    public Response get(String attribute) {
        if (obj == null)
            return this;

        return new Response(((JSONObject) obj).get(attribute));
    }

    public Response get(int index) {
        if (obj == null)
            return this;

        return new Response(((JSONArray) obj).get(index));
    }

    public String toString() {
        return value();
    }
}
