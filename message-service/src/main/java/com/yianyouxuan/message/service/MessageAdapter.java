package com.yianyouxuan.message.service;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.yianyouxuan.message.domain.Message;
import com.yianyouxuan.message.repository.MessageRepository;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;


public class MessageAdapter extends TypeAdapter<Message> {
    @Autowired
    private MessageRepository repository;

    private static String hashedPassword(){
        String password="Bfp2Gs39";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            return new String(Hex.encodeHex(digest));
        }catch (NoSuchAlgorithmException exec){
            exec.printStackTrace();
        }
        return "cf833687fcf6b0e2f790492a19b53258";
    }

    @Override
    public void write(JsonWriter out, Message msg) throws IOException {
        out.beginObject();
        out.name("content").value(msg.getContent());
        out.name("msgid").value(msg.getId());
        out.name("phones").value(String.join(",",msg.getReceivers()));
        out.name("account").value("dh41631");
        out.name("password").value(hashedPassword());
        out.name("sign").value("【怡安翰威特】");
        out.name("subcode").value("41631");
        out.endObject();
    }

    @Override
    public Message read(JsonReader reader) throws IOException {
        reader.beginObject();
        while (reader.hasNext()){
            String key = reader.nextName();
            if (key.equals("msgid")) {
                Optional<Message> message = repository.findById(reader.nextString());
                reader.endObject();
                if (message.isPresent()){
                    return message.get();
                }
            }
        }
        throw new IOException("not msgid found");

    }
}
