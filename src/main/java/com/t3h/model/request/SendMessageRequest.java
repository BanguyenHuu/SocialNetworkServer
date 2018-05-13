package com.t3h.model.request;

/**
 * Created by Lap trinh on 3/28/2018.
 */
public class SendMessageRequest {
    private String receiverId;
    private String content;

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
