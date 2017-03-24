/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zulfiqarjunejo.websocket;

import com.zulfiqarjunejo.model.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.websocket.Session;

/**
 *
 * @author zulfi
 */

@ApplicationScoped
public class ChatSessionHandler {
    private final List<Message> messages = new ArrayList<>();
    private final List<Session> sessions = new ArrayList<>();
    
    public void addSession(Session session) {
        sessions.add(session);
        messages.forEach((Message message) -> {
            sendToSession(session, message);
        });
    }
    
    public void addMessage(Message message) {
        boolean add = messages.add(message);
        if (add) {
            sessions.forEach((Session session) -> {
                sendToSession(session, message);
            });
        } else {
            System.out.println("Could not add message to the messages");
        }
    }
    
    public void printAllMessages() {
        System.out.println("Contents of messages");
        messages.forEach(message -> {
            System.out.println(message.getText());
        });
    }
    
    private void sendToSession(Session session, Message message) {
        try {
            session.getBasicRemote().sendText(message.getText());
        } catch (IOException ex) {
            Logger.getLogger(ChatSessionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
