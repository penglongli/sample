package com.sample.config.queues;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultConfig {

    public final static String DEFAULT_HI_QUEUE = "default-hi-queue";

    @Bean
    public Queue hiDefaultQueue() {
        return new Queue(DEFAULT_HI_QUEUE);
    }
}
