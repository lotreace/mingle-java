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

import org.junit.*;
import static org.junit.Assert.*;

public class TestCases {

    @Test
    public void testExchange() throws Exception {
        Connection ex = new Connection("https://data.mingle.io/");
        Response resp = ex.run("[ g | g <- geonames, lower(g.altnames) =~ `wallisellen` ]");
        assertNotNull(resp);
        assertNotNull(resp.get("time"));
    }

    @Test
    public void testGeonames() throws Exception {
        Mingle mingle = new Mingle();
        assertValidResponse(mingle.geonames().getPlacesNearby(32.321f, 8.322f, 20f));
        assertValidResponse(mingle.geonames().getCountryInfo("GB"));
        assertValidResponse(mingle.geonames().getPlacesNearbyOfType(32.321f, 8.322f, 20f, "PPL")); //populated places
        assertValidResponse(mingle.geonames().getTimeZoneForCountry("CH"));

    }

    private Response assertValidResponse(Response resp) throws Exception{
        assertNotNull(resp);
        assertNotNull(resp.get("head"));
        assertNotNull(resp.get("body"));
        assertNotNull(resp.get("total"));
        assertNotNull(resp.get("time"));
        assertNotNull(resp.get("found"));
        System.out.println("GOT HEAD: \t"+resp.get("head"));
        System.out.println("GOT BODY: \t"+resp.get("body"));
        System.out.println("GOT TOTAL: \t"+resp.get("total"));
        System.out.println("GOT TIME: \t"+resp.get("time"));
        System.out.println("GOT FOUND: \t"+resp.get("found"));
        return resp;
    }
}
