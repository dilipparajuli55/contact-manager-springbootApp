package com.dilipcodes.service;

import com.dilipcodes.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    boolean register(User user);
}
