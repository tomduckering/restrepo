package org.duckering.restrepo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: tduckerin
 * Date: 11/04/2011
 * Time: 15:57
 * To change this template use File | Settings | File Templates.
 */
public class ArtifactRepository {

    private Map<Integer,Artifact> artifacts = new HashMap<Integer,Artifact>();

    public int put(final Artifact artifact) {
        int id = this.generateID();
        artifacts.put(id,artifact);
        return id;
    }

    public Artifact get(Integer id) {
        return artifacts.get(id);
    }

    private Integer generateID() {
        return artifacts.size() + 1;
    }

}
