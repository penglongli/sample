package com.sample.config.queues;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectQueuesConfig {

    public final static String DIRECT_EXCHANGE = "direct.exchange";

    public final static String DIRECT_HI_QUEUE = "direct-hi-queue";
    public final static String DIRECT_HI_ROUTING = "direct.hi.routing";

    public final static String DIRECT_HELLO_QUEUE = "direct-hello-queue";
    public final static String DIRECT_HELLO_ROUTING = "direct.hello.routing";

    @Bean
    public Queue hiDirectQueue() {
        return new Queue(DIRECT_HI_QUEUE);
    }

    @Bean
    public Queue helloDirectQueue() {
        return new Queue(DIRECT_HELLO_QUEUE);
    }
}
