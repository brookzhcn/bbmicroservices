package com.yianyouxuan.message.service;

import com.google.gson.TypeAdapter;
import com.yianyouxuan.message.domain.Message;
import feign.Feign;
import feign.gson.GsonEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;


@Service
public class DahanService  {
    private static final Logger logger = LoggerFactory.getLogger(DahanService.class);
    private final DahanClient dahanClient;

    public DahanService() {
        MessageAdapter messageAdapter = new  MessageAdapter();
        this.dahanClient = Feign.builder().encoder(new GsonEncoder(Collections.singleton(messageAdapter)))
                .target(DahanClient.class,"http://localhost:4000");

    }

    @Async
    public CompletableFuture<Message> sendMessage(Message message) throws InterruptedException{
        logger.info("prepare to send message" + message);
        dahanClient.sendSms(message);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(10000L);
        logger.info("message sent" + message);
        return CompletableFuture.completedFuture(message);
    }
}
