package com.example.listossimage.component;

import com.example.listossimage.config.RocketMQConfig;
import com.example.listossimage.repository.ImageRepository;
import com.example.listossimage.service.MessageHandle;
import com.example.listossimage.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;


/**
 * rocketMQ消费者
 */
@Slf4j
@Component
public class RocketMQConsumer {

    //消费者实体
    private DefaultMQPushConsumer consumer;

    @Autowired
    private MessageHandle messageHandle;

    //消费者组
    public static final String CONSUMER_GROUP = "test-consumer";

    //通过构造函数 实例化对象
    //@PostConstruct
    public RocketMQConsumer() throws MQClientException {
        consumer = new DefaultMQPushConsumer(CONSUMER_GROUP);
        consumer.setNamesrvAddr(RocketMQConfig.NAME_SERVER);
        //消费模式：一个新的订阅组第一次启动从队列的最后位置开始消费 后续再接着上次消费的进度开始消费
        //consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //订阅主题和 标签下信息
        consumer.subscribe(RocketMQConfig.TOPIC, "*");

        //注册消费监听器 并在监听器中消费消息， 并返回消费的状态信息
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            // msgs中只收集同一个topic，同一个tag，并且key相同的message
            // 会把不同的消息分别放置到不同的队列中
            for (MessageExt msg : msgs) {
                try {
                    messageHandle.handleMessage(msg);
                    log.info("消息处理成功！");
                } catch (UnsupportedEncodingException e) {
                    log.error("消息处理失败！");
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;

        });
        consumer.start();
        System.out.println("消费者 启动成功=======");
    }
}
