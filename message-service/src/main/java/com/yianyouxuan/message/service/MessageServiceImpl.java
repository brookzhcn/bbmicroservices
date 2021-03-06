package com.yianyouxuan.message.service;

import com.yianyouxuan.message.domain.Message;
import com.yianyouxuan.message.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageRepository repository;

    @Autowired
    private DahanService dahanService;

    @Override
    public Message create(Message message) {
        Message msg = repository.save(message);
        log.info("new message has been created: {}", message);
        return msg;
    }

    @Override
    public boolean send(Message message){
        if(!message.isSent()) {
            try {
                dahanService.sendMessage(message);
                return true;
            } catch (InterruptedException exec) {
                return false;
            }

        }
        return false;
    }
}
