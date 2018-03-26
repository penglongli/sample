package com.sample.service.defaul;

import com.sample.config.queues.DefaultConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class DefaultReceiver {

    @RabbitListener(queues = DefaultConfig.DEFAULT_HI_QUEUE)
    public void receiveHi(String msg) {
        System.out.println("Received <" + msg + ">");
    }
}
