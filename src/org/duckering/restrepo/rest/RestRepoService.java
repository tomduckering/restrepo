package org.duckering.restrepo.rest;

import com.sun.jersey.multipart.BodyPart;
import com.sun.jersey.multipart.MultiPartMediaTypes;
import com.sun.jersey.multipart.MultiPart;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/artifact")
public class RestRepoService {

    private
    @Context
    UriInfo uriInfo;
    private ArtifactRepository artifactRepository;

    public RestRepoService() {
        this.artifactRepository = new ArtifactRepository();
         artifactRepository.put(new Dictionary());
         artifactRepository.put(new Dictionary());
    }

    public RestRepoService(ArtifactRepository artifactRepository) {
        this.artifactRepository = artifactRepository;

    }

    @Path("/{artifactId}")
    @GET
    @Produces("application/vnd.restrepo+xml")
    public Response doGet(@PathParam("artifactId") int artifactId) {

        Dictionary dictionary = artifactRepository.get(artifactId);

        dictionary.put("ab","cd");

        return Response.ok().entity(dictionary).build();
    }

    @PUT
    //@Produces("application/vnd.restrepo+xml")
    @Consumes(MultiPartMediaTypes.MULTIPART_MIXED)
//    public Response doPut(@Multipart(value = "data", type = "application/octet-stream") Data data,
//                          @Multipart(value = "dictionary", type = "application/xml") Dictionary dictionary) {
//
    public Response doPut(MultiPart multipart) {
        Data data = null;
        Dictionary dictionary = null;
        for(BodyPart bodyPart:multipart.getBodyParts()) {
            if (bodyPart.getMediaType().equals(MediaType.APPLICATION_OCTET_STREAM_TYPE)) {
                data = bodyPart.getEntityAs(Data.class);
            }

            if (bodyPart.getMediaType().equals(MediaType.APPLICATION_XML_TYPE)) {
                dictionary = bodyPart.getEntityAs(Dictionary.class);

            }
        }

        if (data == null || dictionary == null) {
            return Response.serverError().build();
        }

        int newArtifactId = artifactRepository.put(dictionary);

        try {
            return Response.created(new URI(uriInfo.getAbsolutePath()+"/"+newArtifactId)).build();
        } catch (URISyntaxException e) {
            return Response.serverError().build();
        }
    }
}
