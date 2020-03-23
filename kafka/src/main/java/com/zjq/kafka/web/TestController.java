package com.zjq.kafka.web;

import com.zjq.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:模拟请求接口
 * @author: BadGuy
 * @date: 2020-03-23 09:15
 **/
@RestController
public class TestController {

    @Autowired
    private KafkaProducer producer;

    @RequestMapping("/testMsg")
    public String testSendMsg(){
        producer.send();
        return "success";
    }

}
