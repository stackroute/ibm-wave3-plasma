package com.stackroute.plasma.seedcomponent;
import com.stackroute.plasma.model.UserAuth;
import com.stackroute.plasma.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Data
@Primary
public class SeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

 private UserRepository userRepository;

    @Autowired
    public SeedDataApplicationListener(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        userRepository.save(new UserAuth("admin", "123","admin"));
        userRepository.save(new UserAuth("Sai", "kodi","user"));
    }
}

