package org.ckj.springmqconsumer.receiver;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-13  10:27
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class TopicManReceiver {
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "topicExchange",durable = "true",type = "topic"),
            value    = @Queue(value = "topic.man",durable = "true"),
            key = "topic.man"
    ))
    public void process(Map testMessage) {
        System.out.println("TopicManReceiver消费者收到消息  : " + testMessage.toString());
    }
}
