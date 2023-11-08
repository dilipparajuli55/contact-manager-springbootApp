package com.dilipcodes.configuration;

import com.dilipcodes.model.User;
import com.dilipcodes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from dB
        User user = userService.getUserByUsername(username);
        // Check if the user exists
        if ( user == null ){
            throw new UsernameNotFoundException("Coud not find user " + user);
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        return customUserDetails;
    }
}
