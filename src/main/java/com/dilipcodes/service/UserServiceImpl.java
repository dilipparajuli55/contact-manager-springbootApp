package com.dilipcodes.service;

import com.dilipcodes.model.User;
import com.dilipcodes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean register(User user) {
        userRepository.save(user);
        return true;
    }
}
