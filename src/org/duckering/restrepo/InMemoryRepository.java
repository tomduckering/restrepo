package org.duckering.restrepo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: tduckerin
 * Date: Apr 4, 2011
 * Time: 1:59:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class InMemoryRepository implements Repository {

    private Map<Hash,Artifact> artifacts = new HashMap<Hash,Artifact>();
    private Hasher hasher;

    public InMemoryRepository(Hasher hasher) {
        this.hasher = hasher;
    }

    public Hash put(Artifact artifact) {
        Hash hash = hasher.generateHash(artifact.getData());
        artifacts.put(hash,artifact);

        return hash;
    }

    public Hash put(Artifact artifact, Map<String, String> metaData) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Artifact get(Hash hash) {
        return artifacts.get(hash);
    }

    public Artifact get(Map<String, String> metaData) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
