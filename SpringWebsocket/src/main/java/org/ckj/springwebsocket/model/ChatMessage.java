package org.ckj.springwebsocket.model;

import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-13  11:40
 * @Description: TODO
 * @Version: 1.0
 */
@Transactional
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType {
        //消息
        CHAT,
        //离线
        LEAVE,
        //上线
        JOIN
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
