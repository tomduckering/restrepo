package org.duckering.restrepo;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: tduckerin
 * Date: Apr 4, 2011
 * Time: 1:57:26 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Repository {


    public Hash put(Artifact artifact);

    public Hash put(Artifact artifact, Map<String,String> metaData);

    public Artifact get(Hash hash);

    public Artifact get(Map<String,String> metaData);

}
