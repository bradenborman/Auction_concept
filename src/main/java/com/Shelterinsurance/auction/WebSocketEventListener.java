package com.Shelterinsurance.auction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class WebSocketEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    private AtomicInteger usersConnected = new AtomicInteger(0);


    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        usersConnected.incrementAndGet();
        logger.info("Received a new web socket connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        usersConnected.decrementAndGet();
        logger.info("Subscriber lost");
    }

    public int getUsersConnected() {
        return usersConnected.get();
    }

}
