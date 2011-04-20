package org.duckering.restrepo.rest;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.duckering.restrepo.Artifact;
import org.duckering.restrepo.ArtifactRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Path("/artifact")
public class RestRepoService {

    private
    @Context
    UriInfo uriInfo;
    private ArtifactRepository artifactRepository;

    public RestRepoService(ArtifactRepository artifactRepository) {
        this.artifactRepository = artifactRepository;
    }

    @Path("/{artifactId}")
    @GET
    @Produces("application/vnd.restrepo+xml")
    public Response doGet(@PathParam("artifactId") int artifactId) {

        Artifact artifact = artifactRepository.get(artifactId);

        return Response.ok().entity(artifact).build();
    }

    @PUT
    @Produces("application/vnd.restrepo+xml")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response doPut(MultipartBody multipartBody) {
        Attachment a = multipartBody.getAttachment("file");
        ContentDisposition cd = a.getContentDisposition();
        try {
            InputStream is = a.getDataHandler().getInputStream();
        } catch (IOException e) {
            return Response.serverError().build();
        }

        return Response.ok().build();
    }
}
