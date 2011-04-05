package org.duckering.restrepo;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: tduckerin
 * Date: Apr 4, 2011
 * Time: 2:09:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hash {

    public byte[] hashData;

    public Hash(byte[] hashData) {
        this.hashData = hashData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hash hash = (Hash) o;

        if (!Arrays.equals(hashData, hash.hashData)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return hashData != null ? Arrays.hashCode(hashData) : 0;
    }
}
