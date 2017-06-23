package com.dell.pravegasearch.server.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
{
    private static final Logger _log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args)
    {
        _log.info("Pravega Search rest server is starting");

        final FrontEndV1 frontend = new FrontEndV1();
        try {
            System.out.print("test");
           frontend.start();
        } catch (Exception e) {
            _log.error("fail to start: ", e);
            e.printStackTrace();
            System.exit(1);
        }

        _log.info("Pravega Search rest server exit");
    }
}