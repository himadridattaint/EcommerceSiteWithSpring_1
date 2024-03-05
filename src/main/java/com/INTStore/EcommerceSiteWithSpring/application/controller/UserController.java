package com.INTStore.EcommerceSiteWithSpring.application.controller;

import com.INTStore.EcommerceSiteWithSpring.application.model.User;
import com.INTStore.EcommerceSiteWithSpring.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController
{
    @Autowired
    private UserService userService;
    @GetMapping("/all-user")
    public List<User> getAllUsers()
    {
        return userService.getAllUser();
    }
    @PostMapping("/register-user")
    public void saveNewUser(@RequestBody User user)
    {
        userService.saveNewUser(user);
    }



}
