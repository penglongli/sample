package com.sample.service.defaul;

import com.sample.config.queues.DefaultConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendHi() {
        rabbitTemplate.convertAndSend(DefaultConfig.DEFAULT_HI_QUEUE, "Hi, Default");
    }
}
