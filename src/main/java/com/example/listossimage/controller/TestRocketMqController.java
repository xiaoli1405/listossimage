package com.example.listossimage.controller;

import com.example.listossimage.component.RocketMQProducer;
import com.example.listossimage.config.RocketMQConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "TestRocketMqController", description = "测试生产者发送消息接口")
@Slf4j
@RestController
@RequestMapping("/rocketmq")
public class TestRocketMqController {

    @Autowired
    private RocketMQProducer producer;

    private List<String> mesList;

    public TestRocketMqController() {
        mesList = new ArrayList<>();
        mesList.add("11111");
        mesList.add("22222");
        mesList.add("33333");
        mesList.add("44444");
        mesList.add("55555");
        mesList.add("66666");
    }

    @ApiOperation("生产者发送消息")
    @RequestMapping(value = "/text", method = RequestMethod.GET)
    public Object callback() throws Exception {
        for (String s : mesList) {
            //创建生产信息
            Message message = new Message(RocketMQConfig.TOPIC, "testtag", ("xiaoxiaoyijiaren" + s).getBytes());
            //发送信息
            SendResult send = producer.getProducer().send(message);
            log.info("输出生产者信息={}", send);
        }
        return "成功";
    }
}
