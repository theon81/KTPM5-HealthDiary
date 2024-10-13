package com.project.health_diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.health_diary.model.User;
import com.project.health_diary.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String name, String password){
        User account = userRepository.findByUsernameAndPassword(name, password);
        if(account != null && account.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
