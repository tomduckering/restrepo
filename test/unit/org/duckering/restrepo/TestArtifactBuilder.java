package org.duckering.restrepo;

public class TestArtifactBuilder {

    public static Artifact buildBasicArtifact() {
        byte[] data = new byte[10];
        Artifact artifact;
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) i;
        }
        artifact = new Artifact(data);
        return artifact;
    }
}