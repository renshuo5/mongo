package com.rensframework.socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class HelloHandler extends TextWebSocketHandler {
	private static final List<WebSocketSession> users = new ArrayList<>();
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
		// 接收到客户端消息时调用
		System.out.println("text message: " + session.getId() + "-"
				+ message.getPayload());
		
		//session.sendMessage(message);
		sendMessageToUsers(message);
	}

	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		// 与客户端完成连接后调用
		System.out.println("afterConnectionEstablished");
		System.out.println("getId:" + session.getId());
		System.out.println("getLocalAddress:"
				+ session.getLocalAddress().toString());
		System.out.println("getTextMessageSizeLimit:"
				+ session.getTextMessageSizeLimit());
		System.out.println("getUri:" + session.getUri().toString());
		System.out.println("getPrincipal:" + session.getPrincipal());
		session.sendMessage(new TextMessage("你好".getBytes()));
		users.add(session);
	}

	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		// 消息传输出错时调用
		System.out.println("handleTransportError");
	}

	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) throws Exception {
		// 一个客户端连接断开时关闭
		System.out.println("afterConnectionClosed");
	}

	public boolean supportsPartialMessages() {
		return false;
	}
	
	/**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
