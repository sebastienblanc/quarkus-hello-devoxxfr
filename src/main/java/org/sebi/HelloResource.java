package org.sebi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class HelloResource {

    @ConfigProperty(name = "greeting", defaultValue = "Bonjour")
    String greeting;

    final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");

    private int count = 0;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        count++;
        return greeting + " Devoxx France ! from " + hostname + " " + count ;
    }

}