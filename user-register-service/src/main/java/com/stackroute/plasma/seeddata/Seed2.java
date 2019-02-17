package com.stackroute.plasma.seeddata;

import com.stackroute.plasma.domain.User;
import com.stackroute.plasma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Seed2 implements ApplicationListener<ContextRefreshedEvent> {

    UserRepository userRepository;

    @Autowired
    public Seed2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        userRepository.save(new User("1", "MadhuSekhar", "13-08-1997", "Female","7659055124", "madhuneelima1@gmail.com", "madhu", "madhu"));
        userRepository.save(new User("2", "NeelimaMadhuri", "14-08-1997", "Female","9666666666", "neelima.guturi@gmail.com", "neelu", "neelu"));
    }
}