package com.dell.pravegasearch.server.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("helloworld")
public class RestApi {
    public static final String TEST_MESSAGE = "Hello World!";

    @GET
    @Produces("text/plain")
    public String getHello() {
        return TEST_MESSAGE;
    }

}