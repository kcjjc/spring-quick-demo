package org.ckj.springmqconsumer.receiver;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-13  10:31
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class TopicWomanReceiver {

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "topicExchange",durable = "true",type = "topic"),
            value    = @Queue(value = "topic.woman",durable = "true"),
            key = "topic.#"
    ))
    public void process(Map message) {
        System.out.println("Topic Receiver2  : " + message.toString());
    }

}
