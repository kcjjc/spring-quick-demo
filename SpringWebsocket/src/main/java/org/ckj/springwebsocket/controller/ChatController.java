package org.ckj.springwebsocket.controller;

import org.ckj.springwebsocket.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-13  11:42
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
public class ChatController {

    //定义消息请求路径
    @MessageMapping("/chat.sendMessage")
    //定义结果发送到特定路径
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    //当接收到发往/chat.addUser这个目的地的 WebSocket 消息 会调用下列方法
    @MessageMapping("/chat.addUser")
    // 处理完将结果发送到目的地
    @SendTo("/topic/public")
    // payload这个参数是从接收到的 WebSocket 消息体中提取出来的
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        //Add username in web socket session
        //getSessionAttributes获取当前 WebSocket 会话的属性集合 可用于存储用户信息
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
