package org.duckering.restrepo;

import org.duckering.restrepo.rest.Dictionary;

public class TestArtifactBuilder {

    public static Dictionary buildBasicArtifact() {
       Dictionary dictionary = new Dictionary();
       dictionary.put("name","value");
       return dictionary;
    }
}