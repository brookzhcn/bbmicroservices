package com.yianyouxuan.message.domain;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import java.io.Serializable;

@Document(collection = "message")
public class Message {
    @Id
    private String  id;
    private final String content;
    private final List<String> receivers;
    private final String sender;
    private boolean sent;
//    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    private final Date dateCreated;
    private  Date dateSent;

    public Message(String content, List<String> receivers, String sender) {
        this.content = content;
        this.receivers = receivers;
        this.sender=sender;
        this.sent= false;
        this.dateCreated= new Date();
        this.dateSent = null;
    }
    public Message(){
        this.content="";
        this.receivers =new ArrayList<>();
        this.sender="";
        this.sent = false;
        this.dateSent = null;
        this.dateCreated =new Date();
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public String getContent() {
        return content;
    }

    public List<String> getReceivers() {
        return receivers;
    }

    public String getSender() {
        return sender;
    }

    public String getId() {
        return id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public boolean isSent() {
        return sent;
    }

    @Override
    public String toString() {
        return String.format(
                "Message[receivers='%s', content='%s',sender='%s']",
                receivers,content,sender);
    }
}
