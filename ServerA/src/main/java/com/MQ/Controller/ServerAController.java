package com.MQ.Controller;

import com.MQ.Result;
import com.MQ.Serve;
import com.MQ.Service.ServerAService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RabbitListener(queues = "cToA")
public class ServerAController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private ServerAService serverAService;


    Result result = new Result();

    @PostMapping("/send/{id}/{name}")
    public Result sendAToB(@PathVariable("id") int id,@PathVariable("name") String name){

        //写库
        Serve serveA = new Serve();
        serveA.setId(id);
        serveA.setName(name);

        serverAService.insertA(id,name);
        System.out.println("A写库完成");
        amqpTemplate.convertAndSend("aToB",serveA);
        System.out.println("A向B发送");

        return result;

    }

    @RabbitHandler
    public void receiverCToA(Serve serveC){
        System.out.println("接收到C -> A");
        String name = serveC.getName();
        if (name.contains("_B_C")){
            result.setSuccess(true);
            result.setMessage("A->B->C");
        }else{
            result.setSuccess(false);
            result.setMessage("还不知道哪里出错");
        }
    }
}
