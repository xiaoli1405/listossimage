package com.example.listossimage.testmq;


import com.example.listossimage.ListossimageApplicationTests;
import com.example.listossimage.component.RocketMQProducer;
import com.example.listossimage.config.RocketMQConfig;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;

public class TestMq extends ListossimageApplicationTests {

    /**
     * 测试生产者发送消息过程
     * @throws InterruptedException
     * @throws RemotingException
     * @throws MQClientException
     * @throws MQBrokerException
     */
    @Test
    public void testMq() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        //生产者发送消息
        DefaultMQProducer producer = new DefaultMQProducer("test1_producer");
        producer.start();
        producer.setNamesrvAddr(RocketMQConfig.NAME_SERVER);
        Message message = new Message("test-topic", "ceshixiaoxi".getBytes());
        producer.send(message);
        producer.shutdown();

        //消费者消费消息
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test1-consumer");
        consumer.setNamesrvAddr(RocketMQConfig.NAME_SERVER);
        consumer.subscribe("test-topic", "*");
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            for (MessageExt msg : msgs) {
                System.out.println(msg + "测试输出结果");
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        System.out.println("消费结束");
        consumer.start();
    }


}
