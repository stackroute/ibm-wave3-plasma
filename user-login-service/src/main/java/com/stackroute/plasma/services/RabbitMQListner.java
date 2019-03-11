package com.stackroute.plasma.services;

import com.stackroute.plasma.model.User;
import com.stackroute.plasma.model.UserAuth;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class RabbitMQListner {
    @Autowired
    UserService userService;

    UserAuth userAuth;

    @RabbitListener(queues = "${javainuse3.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void recievedMessage(User user) throws IOException {
         System.out.println("recieved msg from rabbit" + user.getEmailId());
         userAuth=new UserAuth(user.getEmailId(),user.getPassword(),user.getName(),user.getDateOfBirth(),user.getGender(),user.getContact(),"user");
            userService.saveUsers(userAuth);
    }
}
