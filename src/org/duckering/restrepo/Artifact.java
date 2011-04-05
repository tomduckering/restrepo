package org.duckering.restrepo;

public class Artifact {

    private byte[] data;

    public Artifact(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }
    
}