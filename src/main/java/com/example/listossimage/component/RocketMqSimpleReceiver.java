package com.example.listossimage.component;

import com.example.listossimage.config.RocketMQConfig;
import com.example.listossimage.repository.ImageRepository;
import com.example.listossimage.service.RedisService;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
        topic = RocketMQConfig.TOPIC,	//指定topic
        consumerGroup = "test_consumer" //指定消费组
)
public class RocketMqSimpleReceiver implements RocketMQListener<String> {

    @Autowired
    private RedisService redisService;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void onMessage(String s) {
        System.out.println("simple:"+s);
//        String[] split = s.split(":");
        String s1 = redisService.get(s);
        String[] split1 = s1.split(",");
        for (String s2 : split1) {
            System.out.println(s2);
        }
        imageRepository.InsertImage(split1[1], split1[0]);
    }
}