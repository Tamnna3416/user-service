package com.sarvika.demo.service;

import org.springframework.stereotype.Service;

import com.sarvika.demo.exception.UserNotFoundException;
import com.sarvika.demo.model.User;
import com.sarvika.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
    	log.info("Saving user: {}", user);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        log.info("Fetching user with ID: {}", id);
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
    }

    public void deleteUser(Long id) {
        log.info("Attempting to delete user with ID: {}", id);
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }
}
