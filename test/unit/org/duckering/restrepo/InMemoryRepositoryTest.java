package org.duckering.restrepo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: tduckerin
 * Date: Apr 4, 2011
 * Time: 2:03:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class InMemoryRepositoryTest {
    @Test

    public void testPutandGet() throws Exception {
        Artifact artifact = TestArtifactBuilder.buildBasicArtifact();
        Hasher hasher = new BasicHasher();
        InMemoryRepository repo = new InMemoryRepository(hasher);

        Hash hash = hasher.generateHash(artifact.getData());

        repo.put(artifact);

        Artifact fetchedArtifact = repo.get(hash);

        assertEquals(artifact,fetchedArtifact);

    }
}
