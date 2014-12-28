package com.test.websocket.service;

import com.test.websocket.model.HeartBeat;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;


public class HeartBeatService {

    final static Logger logger = LoggerFactory.getLogger(HeartBeatService.class);

    @Autowired
    Registrar registrar;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedDelay=1000)
    public void schedule() {
        sendHeartBeat();
    }

    private void sendHeartBeat()
    {
        logger.debug("heart beat");

        Set<String> clients = registrar.currentClients();

        for (String client : clients)
        {
            simpMessagingTemplate.convertAndSend("/topic/heartbeat", new HeartBeat(DateTime.now()));
            logger.info("sent heart beat to client:{}", client);
        }
    }

}
