package com.sample.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableRabbit
public class AmqpConfig {

    @Value("${amqp.host}")
    private String amqpUrl;

    @Value("${amqp.port}")
    private Integer amqpPort;

    @Value("${amqp.user}")
    private String amqpUser;

    @Value("${amqp.pass}")
    private String amqpPass;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory(amqpUrl, amqpPort);
        factory.setUsername(amqpUser);
        factory.setPassword(amqpPass);
        //factory.setVirtualHost("/");

        return factory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }
}
