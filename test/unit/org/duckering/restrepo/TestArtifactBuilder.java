package org.duckering.restrepo;

public class TestArtifactBuilder {

    public static Artifact buildBasicArtifact() {
       Artifact artifact = new Artifact();
       artifact.put("name","value");
       return artifact;
    }
}