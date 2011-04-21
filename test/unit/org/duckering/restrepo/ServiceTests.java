package org.duckering.restrepo;

import org.duckering.restrepo.rest.ArtifactRepository;
import org.duckering.restrepo.rest.Data;
import org.duckering.restrepo.rest.Dictionary;
import org.duckering.restrepo.rest.RestRepoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
        Dictionary expectedDictionary = new Dictionary();
        String name = "name";
        expectedDictionary.put(name, "value");

        int artifactId = artifactRepository.put(expectedDictionary);

        Response r = restRepositoryService.doGet(artifactId);

        Dictionary actualDictionary = (Dictionary)r.getEntity();
        
        Assert.assertEquals(expectedDictionary.get(name), actualDictionary.get(name));
    }

    @Ignore
    @Test
    public void testPutOfBasicResource() {

        Dictionary dictionary = new Dictionary();
        dictionary.put("name", "value");

        //Response r = restRepositoryService.doPut(new Data(),dictionary);

        //Assert.assertEquals(Response.Status.OK.getStatusCode(),r.getStatus());
    }
}
