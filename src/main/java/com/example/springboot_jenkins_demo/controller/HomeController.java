package com.example.springboot_jenkins_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_jenkins_demo.model.Student;
import com.example.springboot_jenkins_demo.service.StudentService;

@RestController
public class HomeController {

    @Autowired
    StudentService service;

    @PostMapping("/student")
    public Student add(@RequestBody Student s) {
        return service.save(s);
    }
    @GetMapping("/")
public String home() {
    return "Hello Spring Boot ********************";
}

}