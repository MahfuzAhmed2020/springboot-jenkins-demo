package com.example.springboot_jenkins_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_jenkins_demo.model.Student;
import com.example.springboot_jenkins_demo.service.StudentService;




import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.springboot_jenkins_demo.model.Student;
import com.example.springboot_jenkins_demo.service.StudentService;



@RestController
@RequestMapping("/students")
public class StudentController {


    private final StudentService service;


    public StudentController(StudentService service){
        this.service = service;
    }



    //CREATE
    @PostMapping
    public Student create(
            @RequestBody Student student){

        return service.save(student);
    }



    //READ ALL
    @GetMapping
    public List<Student> getAll(){

        return service.findAll();
    }




    //READ ONE
    @GetMapping("/{id}")
    public Student getOne(
            @PathVariable Long id){

        return service.findById(id);
    }




    //PUT UPDATE
    @PutMapping("/{id}")
    public Student update(
            @PathVariable Long id,
            @RequestBody Student student){

        return service.update(id, student);
    }





    //PATCH UPDATE
    @PatchMapping("/{id}")
    public Student patch(
            @PathVariable Long id,
            @RequestBody Student student){

        return service.patch(id, student);
    }





    //DELETE
    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id){

        service.delete(id);

        return "Deleted successfully";
    }

}