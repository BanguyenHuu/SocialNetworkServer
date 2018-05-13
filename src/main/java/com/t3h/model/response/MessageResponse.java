package com.t3h.model.response;

/**
 * Created by Lap trinh on 3/28/2018.
 */
public class MessageResponse {
    private String content;
    private String senderId;
    private String receiverId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
}
