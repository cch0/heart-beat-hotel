package com.test.websocket.service;

import com.google.common.collect.Maps;
import com.test.websocket.model.DateRolledMessage;
import com.test.websocket.model.HeartBeat;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;


import java.util.Map;

public class DailyService {
    static Logger logger = LoggerFactory.getLogger(DailyService.class);

    Map<String, LocalDate> currentDates = Maps.newConcurrentMap();

    @Autowired
    Registrar registrar;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    public void rollTheDate(String client)
    {
        if (registrar.contains(client))
        {
            LocalDate current = currentDates.get(client);

            if (current == null)
            {
                current = LocalDate.now();
            }

            LocalDate nextDate = current.plusDays(1);

            currentDates.put(client, nextDate);

            simpMessagingTemplate.convertAndSend("/topic/" + client, new DateRolledMessage(nextDate, DateTime.now()));
            logger.info("sent DateRolled message to client:{}", client);
        }
        else
        {
            logger.warn("client:{} hasn't registered, cannot roll the date", client);
        }
    }

}
