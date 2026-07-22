package com.example.springboot_jenkins_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_jenkins_demo.model.Student;
import com.example.springboot_jenkins_demo.repository.StudentRepository;




import java.util.List;
import org.springframework.stereotype.Service;

import com.example.springboot_jenkins_demo.model.Student;
import com.example.springboot_jenkins_demo.repository.StudentRepository;


@Service
public class StudentService {


    private final StudentRepository repo;


    public StudentService(StudentRepository repo){
        this.repo = repo;
    }


    //CREATE
    public Student save(Student student){
        return repo.save(student);
    }


    //READ ALL
    public List<Student> findAll(){
        return repo.findAll();
    }


    //READ ONE
    public Student findById(Long id){
        return repo.findById(id)
                .orElse(null);
    }


    //UPDATE
    public Student update(Long id, Student newStudent){

        Student old = repo.findById(id)
                .orElse(null);


        if(old != null){

            old.setName(newStudent.getName());
            old.setEmail(newStudent.getEmail());
            old.setAge(newStudent.getAge());

            return repo.save(old);
        }

        return null;
    }



    //PATCH
    public Student patch(Long id, Student data){

        Student old = repo.findById(id)
                .orElse(null);


        if(old != null){

            if(data.getName()!=null)
                old.setName(data.getName());


            if(data.getEmail()!=null)
                old.setEmail(data.getEmail());


            if(data.getAge()!=0)
                old.setAge(data.getAge());


            return repo.save(old);
        }

        return null;
    }



    //DELETE
    public void delete(Long id){

        repo.deleteById(id);

    }

}