package com.MQ;

import com.MQ.Service.ServerBService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
@RabbitListener(queues = "aToB")
public class ReceiverB {

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private ServerBService serverBService;
    @RabbitHandler
    public void receiverAToB(Serve serveA){

        Serve serveB = new Serve();
        serveB.setId(serveA.getId() + 1);
        serveB.setName(serveA.getName() + "_B");
        int id = serveB.getId();
        String name = serveB.getName();
        serverBService.insertB(id,name);

        System.out.println("B完成写库");

        sendBToC(serveB);
    }

    public void sendBToC(Serve serveB){
        System.out.println("B给C发送");
        amqpTemplate.convertAndSend("bToC",serveB);
    }
}