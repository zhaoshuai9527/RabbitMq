package com.MQ;

import com.MQ.Service.ServerCService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@RabbitListener(queues = "bToC")
public class ReceiverC {

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private ServerCService serverCService;

    @RabbitHandler
    public void receiverBToC(Serve serveB){
        Serve serveC = new Serve();
        serveC.setId(serveB.getId() + 1);
        serveC.setName(serveB.getName() + "_C");
        int id = serveC.getId();
        String name = serveC.getName();
        serverCService.insertC(id,name);

        System.out.println("B完成写库");

        sendCToA(serveC);
    }

    public void sendCToA(Serve serveC){
        String content="Date:"+new Date();
        amqpTemplate.convertAndSend("cToA",serveC);
    }
}