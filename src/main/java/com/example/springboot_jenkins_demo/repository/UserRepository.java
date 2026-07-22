package com.example.springboot_jenkins_demo.repository;

import com.example.springboot_jenkins_demo.model.User;


import org.springframework.data.jpa.repository.JpaRepository;




public interface UserRepository 
extends JpaRepository<User,Long>{


boolean existsByEmail(String email);


}