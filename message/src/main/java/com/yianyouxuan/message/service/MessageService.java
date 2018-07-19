package com.yianyouxuan.message.service;

import com.yianyouxuan.message.domain.Message;

public interface MessageService {
    void create(Message message);
    boolean send(Message message);
}
