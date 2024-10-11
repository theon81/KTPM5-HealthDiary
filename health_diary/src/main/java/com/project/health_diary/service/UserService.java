package com.project.health_diary.service;

import com.project.health_diary.model.User;
import com.project.health_diary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public void save(User user) {
        userRepository.save(user);
    }
}
