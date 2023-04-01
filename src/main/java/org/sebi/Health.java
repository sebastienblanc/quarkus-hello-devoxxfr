package org.sebi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("health")
public class Health {
    
    private boolean behave = true;
    private boolean dead = false;

    @GET
    @Path("ready")
    public Response ready() {
        if(behave) {
            return Response.ok().build();
        }
        else {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("live")
    public Response live() {
        if(!dead) {
            return Response.ok().build();
        }
        else {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("shoot")
    public Response shoot(){
        dead = true;
        return Response.ok().build();
    }

    @GET
    @Path("misbehave")
    public Response misbehave(){
        behave = false;
        return Response.ok().build();
    }
    
    @GET
    @Path("behave")
    public Response behave(){
        behave = true;
        return Response.ok().build();
    }

}
