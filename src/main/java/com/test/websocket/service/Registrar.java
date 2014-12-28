package com.test.websocket.service;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Registrar {
    static final Logger logger = LoggerFactory.getLogger(Registrar.class);

    final Map<String, AtomicInteger> clients = Maps.newConcurrentMap();

    public Set<String> currentClients()
    {
        return new HashSet<String>(clients.keySet());
    }

    public boolean contains(String client)
    {
        return clients.containsKey(client);
    }

    public void register(String client) {
        if (StringUtils.isNotBlank(client)) {
            if (clients.containsKey(client))
            {
                clients.get(client).addAndGet(1);
                logger.info("client:{} counter incremented", client);
            }
            else {
                clients.put(client, new AtomicInteger(1));
                logger.info("client:{} registered", client);
            }
        }
        else
        {
            logger.warn("client is blank");
        }
    }

    public void deregister(String client) {
        if (StringUtils.isNotBlank(client)) {
            if (clients.containsKey(client)) {
                AtomicInteger count = clients.get(client);
                if (count.get() == 1)
                {
                    clients.remove(client);
                    logger.info("client:{} de-registered", client);
                }
                else
                {
                    count.decrementAndGet();
                    logger.info("client:{} counter decremented", client);
                }
            }
            else
            {
                logger.warn("client:{} hasn't registered", client);
            }
        }
        else
        {
            logger.info("client is blank");
        }
    }


}
