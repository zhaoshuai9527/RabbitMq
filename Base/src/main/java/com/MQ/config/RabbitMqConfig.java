package com.MQ.config;



import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue Queue1() {
        return new Queue(RabbitMq.QUEUE_NAME_A);
    }

    @Bean
    public Queue Queue2() {
        return new Queue(RabbitMq.QUEUE_NAME_B);
    }

    @Bean
    public Queue Queue3() {
        return new Queue(RabbitMq.QUEUE_NAME_C);
    }

//    @Bean
//    public Exchange exchange(){
//        return new Exchange(RabbitMq.EXCHANGE);
//        }
    }


