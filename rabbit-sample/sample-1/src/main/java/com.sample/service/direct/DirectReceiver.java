package com.sample.service.direct;

import com.sample.config.queues.DirectQueuesConfig;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiver {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = DirectQueuesConfig.DIRECT_HI_QUEUE, durable = "true"),
            exchange = @Exchange(value = DirectQueuesConfig.DIRECT_EXCHANGE, durable = "true"),
            key = DirectQueuesConfig.DIRECT_HI_ROUTING
        )
    )
    public void receiveHi(String message) {
        System.out.println("Received <" + message + ">");
    }
//
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = DirectQueuesConfig.DIRECT_HELLO_QUEUE),
//            exchange = @Exchange(value = DirectQueuesConfig.DIRECT_EXCHANGE),
//            key = DirectQueuesConfig.DIRECT_HELLO_ROUTING
//        )
//    )
//    public void receiveHello(String message) {
//        System.out.println("Received <" + message + ">");
//    }
}