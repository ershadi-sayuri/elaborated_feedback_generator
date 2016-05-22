package com.feedbackgenerator.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ushan on 5/7/2016.
 */
@Path("/controller")
public class RESTController {
    @POST
    @Path("/test")
    @Consumes("text/plain")
    public Response getMessage(String url) {
        return Response.status(200).entity("tess").build();
    }

    @POST
    @Path("/generateFeedback")
    @Consumes("text/plain")
    public Response generateFeedback(String url) {
        return Response.status(200).entity("tess").build();
    }
}
