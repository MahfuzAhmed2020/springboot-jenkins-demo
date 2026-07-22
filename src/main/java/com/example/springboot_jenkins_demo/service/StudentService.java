package com.example.springboot_jenkins_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_jenkins_demo.model.Student;
import com.example.springboot_jenkins_demo.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository repo;

    public Student save(Student s) {
        return repo.save(s);
    }

}