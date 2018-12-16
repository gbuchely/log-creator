package com.gbuchely.logcreator.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.logging.Logger;

@RestController
public class LogCreatorController {

    private static final Logger LOGGER = Logger.getLogger(LogCreatorController.class.getName());

    private String testMessage = "This is a test message";

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    private String start() {
        LOGGER.info(testMessage);
        return testMessage;
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    private String message(@RequestBody Map request) {
        String message = request.get("message").toString();
        LOGGER.info(message);
        return message;
    }
}