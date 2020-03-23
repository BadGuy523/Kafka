package com.zjq.kafka.model;

import lombok.Data;

import java.util.Date;

/**
 * @description: 消息实体类
 * @author: BadGuy
 * @date: 2020-03-23 09:10
 **/
@Data
public class Message {

    private long id;

    private String msg;

    private Date sendTime;

}
