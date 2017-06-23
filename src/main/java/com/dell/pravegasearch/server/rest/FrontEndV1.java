package com.dell.pravegasearch.server.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;
import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class FrontEndV1 {
    private static final Logger _log = LoggerFactory.getLogger(FrontEndV1.class);

    static final String ROOT_PATH = "helloworld";

    private static final URI BASE_URI = URI.create("http://localhost:8080/jerseyexample");

    public static void start() {
        try {
           _log.info("\"Hello World\" Jersey Example App on Netty container.");

            ResourceConfig resourceConfig = new ResourceConfig(RestApi.class);
            final Channel server = NettyHttpContainerProvider.createHttp2Server(BASE_URI, resourceConfig, null);

            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

                public void run() {
                    server.close();
                }
            }));

            _log.info("Application started. (HTTP/2 enabled!)", BASE_URI, ROOT_PATH);;
            Thread.currentThread().join();
        } catch (InterruptedException ex) {
            _log.error("ERROR", ex);
        }
    }
}
