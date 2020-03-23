package com.zjq.kafka.producer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zjq.kafka.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @description: 发送消息
 * @author: BadGuy
 * @date: 2020-03-23 08:58
 **/
@Component
public class KafkaProducer {

    private static Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired(required = false)
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send() {
        for(int i=0;i<5;i++){
            Message message = new Message();
            message.setId(System.currentTimeMillis());
            message.setMsg(UUID.randomUUID().toString()+ "---" +i);
            message.setSendTime(new Date());
            logger.info("发送消息 ----->>>>>  message = {}", gson.toJson(message));
            kafkaTemplate.send("hello", gson.toJson(message));
        }
    }

}
