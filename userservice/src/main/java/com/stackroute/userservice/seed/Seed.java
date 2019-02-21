package com.stackroute.userservice.seed;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Seed implements ApplicationListener<ContextRefreshedEvent> {

UserRepository userRepository;
    @Autowired
    public Seed(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        userRepository.save(new User("1122","akhila","ak123","ak123", "akhila@gmail.com", "{("Movies"), ("TvShows")}", "F"));
//        userRepository.save(new User("2244","akhil","hello1","hello1", "akhila@gmail.com", {("Movies"), ("TvShows")},"M"));

    }
}
