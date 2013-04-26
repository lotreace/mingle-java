package io.mingle.v1;
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

import org.json.simple.*;
import java.io.*;
import java.net.*;

public class Connection {
    private final URL url;

    public Connection(String url) throws Exception {
        this.url = new URL(url);
    }

    public Response run(String comprehension) {
        String expr = "{ \"query\": \"" + comprehension + "\", \"limit\": 10000 }";
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.connect();

            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(expr, 0, expr.length());
            out.flush();
            out.close();

            InputStream in = conn.getInputStream();
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            byte[] chunk = new byte[4096];
            int read = 0;
            while ((read = in.read(chunk)) > 0) {
                buf.write(chunk, 0, read);
            }
            in.close();

            String str = buf.toString();
            System.out.println("GOT JSON: "+str);
            return new Response(JSONValue.parse(str));
        } catch (Exception e) {
            System.err.printf("failed to execute: %s\n", expr);
            e.printStackTrace();
        }

        return null;
    }
}
