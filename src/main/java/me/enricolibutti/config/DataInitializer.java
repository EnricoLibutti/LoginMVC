package me.enricolibutti.config;

import me.enricolibutti.model.User;
import me.enricolibutti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {
    
    private final UserRepository userRepository;
    private boolean alreadySetup = false;
    
    @Autowired
    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }
        
        // Create a test user
        User user = new User();
        user.setUsername("user");
        user.setPassword("password");
        user.setFirstName("John");
        user.setLastName("Doe");
        
        userRepository.save(user);
        
        alreadySetup = true;
    }
}