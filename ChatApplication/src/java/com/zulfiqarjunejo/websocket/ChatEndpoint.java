/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zulfiqarjunejo.websocket;

import com.zulfiqarjunejo.model.Message;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author zulfi
 */

@ApplicationScoped
@ServerEndpoint("/chat")
public class ChatEndpoint {
    
    @Inject
    private ChatSessionHandler sessionHandler;
    
    @OnOpen
    public void onOpen(Session session) {
        sessionHandler.addSession(session);
    }
    
    @OnClose
    public void onClose(Session session) {
    }
    
    @OnError
    public void onError(Throwable session) { 
    }
    
    @OnMessage
    public void onMessage(String text, Session session) {
        Message message = new Message();
        message.setText(text);
        
        sessionHandler.addMessage(message);
    }
}
