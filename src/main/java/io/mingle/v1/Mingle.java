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

public class Mingle {

    public static final String DATA_URL = "https://data.mingle.io/";
    private final Connection connection;
    private String premiumAPIKey;

    public Mingle() throws Exception{
        connection = new Connection(Mingle.DATA_URL);
    }
    public Mingle(String premiumAPIKey) throws Exception{
        this();
        this.premiumAPIKey = premiumAPIKey;
    }

    public Response getDatasetCatalog(){
        return null;
    }

    public Response getDatasetDetails(String datasetId){ return null;}

    public Response getDataset(String datasetId){ return null;}

    public Response query(String comprehension){
        return connection.run(comprehension);
    }

    public Geonames geonames(){
        return new Geonames(connection);
    }

        /*
    // V2.0
    Freebase.Film.Performances.joinWith.
    Freebase.Film.Performances.getBaconNumbers()
    Geonames.Cities.TimeZone
    OpenStreetMaps.
      */
}
