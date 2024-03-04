package com.example.service;

import java.util.List;


import com.example.aspect.TrackUserAction;
import com.example.repositories.UserRepository;
import com.example.model.User;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @TrackUserAction
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @TrackUserAction
    public User saveUser(User user){
        return userRepository.save(user);
    }
    @TrackUserAction
    public void deleteById(int id){
        userRepository.deleteById(id);
    }
}