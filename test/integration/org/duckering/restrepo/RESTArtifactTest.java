package org.duckering.restrepo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

/**
 * Created by IntelliJ IDEA.
 * User: tduckerin
 * Date: Apr 6, 2011
 * Time: 12:17:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class RESTArtifactTest {

    @Test
    public void testArtifactPost() {

        ClientConfig clientConfig = new DefaultClientConfig();
        Client client = Client.create(clientConfig);

        WebResource webRes = client.resource("http://localhost:8080/restrepo/restrepo");

        String output = webRes.path("artifact/123").accept(MediaType.TEXT_PLAIN).get(String.class);

        assertEquals("You requested artifact 123",output);
    }
}
