package me.enricolibutti.service;

import me.enricolibutti.model.User;
import me.enricolibutti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public boolean authenticate(String username, String password) {
        Optional<User> userOpt = findByUsername(username);
        return userOpt.isPresent() && userOpt.get().getPassword().equals(password);
    }
    
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}