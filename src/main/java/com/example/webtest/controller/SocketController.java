package com.example.webtest.controller;

import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnClose;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;
import java.io.IOException;

@Component
@ServerEndpoint("/jsws")
public class SocketController {
    private Session session;

    public SocketController(){
        System.out.println("websocket begin---------------");

    }

    @OnError
    public void onerror(Throwable t){
        System.out.println("error...");
        t.printStackTrace();
    }

    @OnOpen
    public void onopen(Session session){
        System.out.println("open...");
        try {
            session.getBasicRemote().sendText("hello client...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onclose(Session session){
        System.out.println("close....");

    }

    @OnMessage
    public void onsend(Session session,String msg){
        try {
            session.getBasicRemote().sendText("client say:"+msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test(){
        String st = "socket test method";
        System.out.println(st);
    }

}
