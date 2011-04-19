package org.duckering.restrepo.rest;

import org.duckering.restrepo.Artifact;
import org.duckering.restrepo.ArtifactRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/artifact")
public class RestRepoService {

    private @Context UriInfo uriInfo;
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
    public Response doPut() {
        return Response.ok().build();
    }
}
