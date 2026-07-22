package com.example.springboot_jenkins_demo.service;




import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.springboot_jenkins_demo.model.User;
import com.example.springboot_jenkins_demo.repository.UserRepository;


@Service
public class UserService {


private final UserRepository repo;


BCryptPasswordEncoder encoder =
        new BCryptPasswordEncoder();



public UserService(UserRepository repo){
    this.repo=repo;
}



public User register(User user){


if(repo.existsByEmail(user.getEmail()))
{
 throw new RuntimeException("Email already exists");
}


String password =
encoder.encode(user.getPassword());


user.setPassword(password);


return repo.save(user);

}

    // GET ALL USERS
    public List<User> getAllUsers(){

        return repo.findAll();

    }

}