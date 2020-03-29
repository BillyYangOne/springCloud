package com.billy.controller;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * @ServerEndpoint(value = "/wsdemo") 前端通过此 URI 和后端交互，建立连接
 * @Component 不用说将此类交给 spring 管理
 * @OnOpen websocket 建立连接的注解，前端触发上面 URI 时会进入此注解标注的方法，和之前关于 DWR 文章中的 onpage 方法类似
 * @OnClose 顾名思义关闭连接，销毁 session
 * @OnMessage 收到前端传来的消息后执行的方法
 */
@ServerEndpoint(value = "/wsdemo")
@Component
public class MyWebSocket {

    private static int onlineCount = 0;

    private static CopyOnWriteArraySet<MyWebSocket> webSockets = new CopyOnWriteArraySet<>();

    public static CopyOnWriteArraySet<MyWebSocket> getWebSockets() {
        return webSockets;
    }

    public static void setWebSockets(CopyOnWriteArraySet<MyWebSocket> webSockets) {
        MyWebSocket.webSockets = webSockets;
    }

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);

        addOnlineCount();
        System.out.println("有新连接加入，当前在线人数为：" + getOnlineCount());

        try {
            sendMessage("连接已经建立成功@");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO 发生异常");
        }
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        subOnlineCount();
        System.out.println("有一条连接关闭，当前连接人数为：" + getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message, Session session) {

        String sessionId = session.getId();
        System.out.println("来自客户端《"+ sessionId +"》 的消息：" + message);
    }

    @OnError
    public void onError(Session session, Throwable error) {

        System.out.println("发生异常");
        error.printStackTrace();
    }

    private static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }


}
