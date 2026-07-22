package com.example.springboot_jenkins_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_jenkins_demo.model.Student;

public interface StudentRepository
        extends JpaRepository<Student, Long> {
}