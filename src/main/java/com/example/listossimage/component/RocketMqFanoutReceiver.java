package com.example.listossimage.component;

import com.example.listossimage.config.RocketMQConfig;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

//@Component
//@RocketMQMessageListener(
//        topic = "", 		//主题
//        consumerGroup = "",	//消费组
//        messageModel = MessageModel.BROADCASTING //开启广播模式
//)
public class RocketMqFanoutReceiver implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("fanout:"+s);
    }
}