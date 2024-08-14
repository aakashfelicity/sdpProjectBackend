package com.reviewWebsite.flicSite.Controller;

import com.reviewWebsite.flicSite.Entity.UserEntity;
import com.reviewWebsite.flicSite.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")

@CrossOrigin(origins = "http://localhost:3000/")

public class UserController {

    @Autowired

    private UserService userService;

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody UserEntity user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserEntity user) {
        UserEntity existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "Login Successful";
        } else {
            return "Invalid Credentials";
        }
    }

    @DeleteMapping("/delete/{username}")
    public String deleteUser(@PathVariable String username) {
        userService.deleteUserByUsername(username);
        return "User Deleted Successfully";
    }

}