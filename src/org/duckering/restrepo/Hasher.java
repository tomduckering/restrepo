package org.duckering.restrepo;

/**
 * Created by IntelliJ IDEA.
 * User: tduckerin
 * Date: Apr 4, 2011
 * Time: 2:02:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Hasher {

    public Hash generateHash(byte[] data);
    
}
