package org.duckering.restrepo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

public class RESTArtifactTest {

    @Test
    public void testArtifactGet() {

        ClientConfig clientConfig = new DefaultClientConfig();
        Client client = Client.create(clientConfig);

        WebResource webRes = client.resource("http://localhost:8080/restrepo/restrepo");

        String output = webRes.path("artifact/123").accept(MediaType.TEXT_PLAIN).get(String.class);

        assertEquals("You requested artifact 123",output);
    }

    @Test
    public void testArtifactPost() {

        ClientConfig clientConfig = new DefaultClientConfig();
        Client client = Client.create(clientConfig);

        WebResource webRes = client.resource("http://localhost:8080/restrepo/restrepo");

            Map<String,String> facts = new HashMap<String,String>();
            facts.put("name","value");

            MultivaluedMap formData = new MultivaluedMapImpl();
            formData.add("name","value");

        ClientResponse response = webRes.path("artifact").type("application/x-www-form-urlencoded").accept(MediaType.TEXT_PLAIN).post(ClientResponse.class,formData);

        assertEquals(Response.Status.CREATED,response.getStatus());
    }
}
