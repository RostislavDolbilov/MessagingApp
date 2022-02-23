package com.slavadolbilov.server;

import com.slavadolbilov.model.Message;
import com.slavadolbilov.model.MessageDecoder;
import com.slavadolbilov.model.MessageEncoder;
import javax.websocket.*;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@javax.websocket.server.ServerEndpoint(value = "/chat", encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ServerEndpoint {

    static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("joined the chat:    " + session.getId());
        peers.add(session);
    }

    @OnMessage
    public void onMessage(Message message, Session session) throws IOException, EncodeException {
        String user = (String) session.getUserProperties().get("user");
        if (user == null) {
            session.getUserProperties().put("user", message.getSender());
        }
        if ("quit".equalsIgnoreCase(message.getMessage())) {
            session.close();
        }

        System.out.println(session.getId() + " - " + message.getRecipient() + " - " + message.getMessage());

        for (Session peer : peers) {
            if (!session.getId().equals(peer.getId())) {
                peer.getBasicRemote().sendObject(message);
            }
        }
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        System.out.println("left the chat room    " + session.getId());
        peers.remove(session);
        for (Session peer : peers) {
            Message chatMessage = new Message();
            chatMessage.setSender("Server");
            chatMessage.setMessage("left the chat room.   " + (String) session.getUserProperties().get("user"));
            chatMessage.setRecipient(new Date());
            peer.getBasicRemote().sendObject(chatMessage);
        }
    }
}