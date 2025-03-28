package com.example.demogithubactions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api")
public class Controller {
    @Autowired
    private  StudentService studentService;

    @GetMapping
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/test")
    public String test() {
        return "Hello Test staging!";
    }
    @GetMapping("/students")
    public List<Student> getStudentService() {
        return studentService.getStudents();
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

}
