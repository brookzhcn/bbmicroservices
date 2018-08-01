package com.yianyouxuan.message.service;

import com.yianyouxuan.message.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;


@Service
public class DahanService  {
    private static final Logger logger = LoggerFactory.getLogger(DahanService.class);

    @Async
    public CompletableFuture<Message> sendMessage(Message message) throws InterruptedException{
        logger.info("prepare to send message" + message);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(10000L);
        logger.info("message sent" + message);
        return CompletableFuture.completedFuture(message);
    }
}
