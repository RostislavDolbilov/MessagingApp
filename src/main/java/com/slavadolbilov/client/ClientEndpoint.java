package com.slavadolbilov.client;

import com.slavadolbilov.model.Message;
import com.slavadolbilov.model.MessageDecoder;
import com.slavadolbilov.model.MessageEncoder;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.text.SimpleDateFormat;

@javax.websocket.ClientEndpoint(encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ClientEndpoint {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connection established. Session id:   "  + session.getId());
    }

    @OnMessage
    public void onMessage(Message message) {
        System.out.println(simpleDateFormat.format(message.getRecipient())
                + " - " + message.getSender()
                + ":  " +  message.getMessage());
    }
}
