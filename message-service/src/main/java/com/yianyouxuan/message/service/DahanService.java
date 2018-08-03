package com.yianyouxuan.message.service;

import com.google.gson.TypeAdapter;
import com.yianyouxuan.message.domain.Message;
import com.yianyouxuan.message.repository.MessageRepository;
import feign.Feign;
import feign.gson.GsonEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.concurrent.CompletableFuture;


@Service
public class DahanService  {
    private static final Logger logger = LoggerFactory.getLogger(DahanService.class);
    private final DahanClient dahanClient;
    @Value("${dahan.config.url}")
    String url;
    public DahanService() {
        MessageAdapter messageAdapter = new  MessageAdapter();
        this.dahanClient = Feign.builder().encoder(new GsonEncoder(Collections.singleton(messageAdapter)))
                .target(DahanClient.class,"http://3tong.net");

    }

    @Autowired
    private MessageRepository repository;

    @Async
    public CompletableFuture<Message> sendMessage(Message message) throws InterruptedException{
        logger.info("prepare to send message" + message);
        dahanClient.sendSms(message);

        message.setDateSent(new Date());
        message.setSent(true);
        repository.save(message);
        logger.info("message sent" + message);
        return CompletableFuture.completedFuture(message);
    }
}
