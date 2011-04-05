package org.duckering.restrepo;

/**
 * Created by IntelliJ IDEA.
 * User: tduckerin
 * Date: Apr 4, 2011
 * Time: 2:08:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasicHasher implements Hasher {

    public Hash generateHash(byte[] data) {
        
        return new Hash(data);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
