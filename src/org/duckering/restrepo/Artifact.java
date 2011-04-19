package org.duckering.restrepo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "artifact", namespace = "blah")
public class Artifact {

    @XmlElement(name="metadataEntry",namespace = "blah")
    private Map<String,String> metaData;

    public Artifact() {
        metaData = new HashMap<String,String>();
    }

    public void put(String name, String value) {
        metaData.put(name,value);
    }

    public String get(String key) {
        return metaData.get(key);
    }
}