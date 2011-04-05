package org.duckering.restrepo.rest;

import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.xml.bind.JAXBElement;
import javax.xml.ws.Response;

import static javax.xml.ws.Response.*;

/**
 * Created by IntelliJ IDEA.
 * User: tduckerin
 * Date: Apr 5, 2011
 * Time: 11:05:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/restrepo")
public class RestRepoService {



    @Path("/artifact")
    @POST
    @Consumes("multipart/form-data")
    @Produces("application/vnd.restrepo.artifact")
    public String doPost(@FormDataParam("data") FileUploadForm form) {
        return "blaadfadf";

    }


    @Path("/artifact/{artifactId}")
    @GET
    @Produces("text/plain")
    public String doGet(@PathParam("artifactId") String artifactId) {
        return "You requested artifact "+ artifactId;
    }

}
