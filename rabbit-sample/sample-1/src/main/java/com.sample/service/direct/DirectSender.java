package com.sample.service.direct;

import com.sample.config.queues.DirectQueuesConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendHi() {
        rabbitTemplate.convertAndSend(
                DirectQueuesConfig.DIRECT_EXCHANGE,
                DirectQueuesConfig.DIRECT_HI_ROUTING,
                "Hi, Direct"
        );
    }

    public void sendHello() {
        rabbitTemplate.convertAndSend(
                DirectQueuesConfig.DIRECT_EXCHANGE,
                DirectQueuesConfig.DIRECT_HELLO_ROUTING,
                "Hello, Direct"
        );
    }
}
