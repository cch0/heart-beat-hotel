package com.test.websocket.service;


import com.test.websocket.model.Identity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    Registrar registrar;

    @Autowired
    DailyService dailyService;

    @MessageMapping("/hello")
    public void register(Identity message) throws Exception {

        logger.info("received hello for client:{}", message.getClient());
        registrar.register(message.getClient());
    }

    @MessageMapping("/disconnecting")
    public void deregister(Identity message) throws Exception {

        logger.info("received disconnecting for client:{}", message.getClient());
        registrar.deregister(message.getClient());
    }

    @MessageMapping("/roll")
    public void rollTheDate(Identity identity) throws Exception {
        logger.info("received roll for client:{}", identity.getClient());
        dailyService.rollTheDate(identity.getClient());
    }
}
