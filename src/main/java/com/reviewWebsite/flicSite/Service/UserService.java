package com.reviewWebsite.flicSite.Service;

import com.reviewWebsite.flicSite.Entity.UserEntity;
import com.reviewWebsite.flicSite.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class UserService {

    @Autowired

    private UserRepository userRepository;

    public UserEntity registerUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

//    public void deleteUserByUsername(String username) {
//        userRepository.deleteByUsername(username);
//    }

    @Transactional
    public void deleteUserByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

}
