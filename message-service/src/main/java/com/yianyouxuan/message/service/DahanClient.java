package com.yianyouxuan.message.service;
import com.yianyouxuan.message.domain.Message;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient("dahan")
public interface DahanClient {

    @RequestLine("POST /json/sms/Submit")
    @Headers("Content-Type: application/json")
    void sendSms(Message msg);

}
