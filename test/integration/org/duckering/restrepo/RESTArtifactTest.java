package org.duckering.restrepo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.multipart.BodyPart;
import com.sun.jersey.multipart.MultiPart;
import com.sun.jersey.multipart.MultiPartMediaTypes;
import org.duckering.restrepo.rest.Data;
import org.duckering.restrepo.rest.DataWriter;
import org.duckering.restrepo.rest.Dictionary;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class RESTArtifactTest {

    @Test
    public void testArtifactGet() {

        ClientConfig clientConfig = new DefaultClientConfig();
        Client client = Client.create(clientConfig);

        WebResource webRes = client.resource("http://localhost:8080/restrepo");

        ClientResponse response = webRes.path("artifact/1").get(ClientResponse.class);

        assertEquals("response code", Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testArtifactPost() {

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getClasses().add(DataWriter.class);
        Client client = Client.create(clientConfig);

        WebResource webRes = client.resource("http://localhost:8080/restrepo");

        Data data = new Data();
        data.data = new byte[]{1, 2, 3};

        Dictionary dictionary = new Dictionary();
        dictionary.put("bungle", "muncher");

        MultiPart multiPart = new MultiPart().
                bodyPart(new BodyPart(data, MediaType.APPLICATION_OCTET_STREAM_TYPE)).
                bodyPart(new BodyPart(dictionary, MediaType.APPLICATION_XML_TYPE));

        ClientResponse response = webRes.path("artifact").type(MultiPartMediaTypes.MULTIPART_MIXED_TYPE).put(ClientResponse.class, multiPart);
        MultivaluedMap<String, String> headers = response.getHeaders();

        for (String header : headers.keySet()) {

            System.err.println(header+" : " + headers.get(header));
        }

        assertEquals("Creation response code", Response.Status.CREATED.getStatusCode(), response.getStatus());
    }
}
