package org.duckering.restrepo;

import org.duckering.restrepo.rest.RestRepoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

/**
 * Created by IntelliJ IDEA.
 * User: tduckerin
 * Date: 11/04/2011
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
public class ServiceTests {

    private ArtifactRepository artifactRepository;
    private RestRepoService restRepositoryService;

    @Before
    public void setUp() {

        artifactRepository = new ArtifactRepository();
        restRepositoryService = new RestRepoService(artifactRepository);
    }

    @Test
    public void testGetOfBasicResource() {
        Artifact expectedArtifact = new Artifact();
        String name = "name";
        expectedArtifact.put(name, "value");

        int artifactId = artifactRepository.put(expectedArtifact);

        Response r = restRepositoryService.doGet(artifactId);

        Artifact actualArtifact = (Artifact)r.getEntity();
        
        Assert.assertEquals(expectedArtifact.get(name),actualArtifact.get(name));
    }

    @Test
    public void testPutOfBasicResource() {

        Artifact artifactToPut = new Artifact();
        artifactToPut.put("name","value");

        Response r = restRepositoryService.doPut();

        Assert.assertEquals(Response.Status.OK.getStatusCode(),r.getStatus());
    }
}
