package com.project.health_diary.service;

import com.project.health_diary.model.User;
import com.project.health_diary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
