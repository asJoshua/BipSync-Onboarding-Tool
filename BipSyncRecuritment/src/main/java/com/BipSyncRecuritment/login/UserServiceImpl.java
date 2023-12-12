package com.BipSyncRecuritment.login;

import com.BipSyncRecuritment.employees.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    PasswordEncoder passwordEncoder;

    private UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User findByUsername(String username) {

        return userRepository.findUserByUsername(username);

    }

    public boolean usernameAlreadyExists(String username){
        return userRepository.existsByUsername(username);
    }

    public boolean emailAlreadyExists(String userEmail){
        return userRepository.existsByUserEmail(userEmail);
    }

}

