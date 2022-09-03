package com.example.jpaazure01.controller;

import com.example.jpaazure01.model.Student;
import com.example.jpaazure01.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students() {
        List<Student> lst = studentRepository.findAll();
        return lst;
    }

    @GetMapping("/addstudent")
    public List<Student> addStudent() {
        Student std = new Student();
        std.setBorn(LocalDate.now());
        std.setBornTime(LocalTime.now());
        List<Student> lst = studentRepository.findAll();
        std.setName("Autogen"+ lst.size());
        studentRepository.save(std);
        List<Student> lst2 = studentRepository.findAll();
        return lst2;
    }

}
