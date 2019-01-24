package com.gbuchely.logcreator.controller;

import com.gbuchely.logcreator.dto.MessageSet;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class LogCreatorController {

    private static final Logger LOGGER = LogManager.getLogger(LogCreatorController.class.getName());

    private String testMessage = "This is a test message";

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    private String start() {
        LOGGER.info("This is a INFO message");
        LOGGER.debug("This is a DEBUG message");
        LOGGER.error("This is a ERROR message");
        LOGGER.warn("This is a WARN message");
        return testMessage;
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    private String message(@RequestBody Map request) {
        String message = request.get("message").toString();
        LOGGER.info(message);
        return message;
    }

    @RequestMapping(value = "/bash", method = RequestMethod.POST)
    private String bash(@RequestBody List<MessageSet> bashRequest) throws InterruptedException {
        for (MessageSet set: bashRequest) {
            for (int i = 0; i < set.getIterations(); i++) {
                for (String message : set.getMessages()) {
                    LOGGER.info("LGCT123456 - [CREW-METRIC] - " + message);
                    Thread.sleep(set.getDelay());
                }
            }
        }
        return "Done !!!";
    }
}
