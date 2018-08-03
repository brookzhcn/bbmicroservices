package com.yianyouxuan.message.controller;

import com.yianyouxuan.message.domain.Message;
import com.yianyouxuan.message.exceptions.ResourceNotFoundException;
import com.yianyouxuan.message.repository.MessageRepository;
import com.yianyouxuan.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageRepository messageRepository;


    @Value("${dahan.config.sign}")
    private String sign;

    @GetMapping(value = "/{messageId}")
    public Optional<Message> retrieveMessage(@PathVariable String messageId){

        Optional<Message> message = messageRepository.findById(messageId);
        System.out.println(message);
        return message;
    }
    @PostMapping(value = "/{messageId}")
    public Boolean sendMessage(@PathVariable String messageId) throws ResourceNotFoundException{

        Optional<Message> message = messageRepository.findById(messageId);

        System.out.println(this.sign);
        if (message.isPresent()){
            return messageService.send(message.get());
        }else{
            throw new ResourceNotFoundException("message id not found");
        }
    }
    @DeleteMapping(value = "/{messageId}")
    public Boolean deleteMessage(@PathVariable String messageId) throws ResourceNotFoundException{
        Optional<Message> message = messageRepository.findById(messageId);
        if (message.isPresent()){
            messageRepository.delete(message.get());
            return true;
        }else{
            throw new ResourceNotFoundException("message id not found");
        }
    }
    @GetMapping
    public List<Message> retrieveMessageByReceiver(@RequestParam(value = "receiver",required = false) String receiver){
//        List<String> receivers = new ArrayList<>();
//        receivers.add(receiver);
        if (receiver==null){
            return messageRepository.findAll();
        }
        return messageRepository.findByReceivers(receiver);
    }
    @PostMapping
    public  Message add(@RequestBody Message message){
        Message msg = messageService.create(message);
        messageService.send(msg);
        return msg;
    }
}
