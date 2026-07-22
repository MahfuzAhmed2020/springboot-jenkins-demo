package com.example.springboot_jenkins_demo.controller;

import com.example.springboot_jenkins_demo.model.User;
import com.example.springboot_jenkins_demo.service.UserService;

import java.util.List;
import org.springframework.web.bind.annotation.*;






@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {



private final UserService service;



public UserController(UserService service){
    this.service=service;
}



@PostMapping("/register")
public User register(
@RequestBody User user)
{

return service.register(user);

}


    // GET - Get All Users
    @GetMapping
    public List<User> getAllUsers()
    {
        return service.getAllUsers();
    }

}