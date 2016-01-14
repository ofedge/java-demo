package com.vicitf.token.web.websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocketTest {
    
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Received: " + message);
        try {
            session.getBasicRemote().sendText("This is the first server message");
            int sendMessages = 0;
            while (sendMessages < 3) {
                Thread.sleep(5000);
                session.getBasicRemote().sendText("This is an intermediate Server message. Count: " + sendMessages);
                sendMessages++;
            }
            session.getBasicRemote().sendText("This is the last server message");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @OnOpen
    public void onOpen() {
        System.out.println("Client connectd");
    }
    
    @OnClose
    public void onClose() {
        System.out.println("Connection closed");
    }
}