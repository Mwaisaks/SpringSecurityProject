package com.mwaisaka.SpringSecuritySample.controller;

import com.mwaisaka.SpringSecuritySample.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Pookie", 70),
            new Student(2, "Hellen", 75)

    ));


    @GetMapping("/students")
    public List<Student> getStudents (){
        return students;
    }

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf"); //the attribute was retrieved from the html page in browser
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){  //@RequestBody converts JSOn input into a student object
        students.add(student);
        return student;
    }
}

/*

private List<Student> students;

- Declares a List (interface) that holds Student objects.
- We use List<Student> instead of ArrayList<Student> to follow the best practice of coding to an interface rather than an implementation.

new ArrayList<>(List.of(...))
- List.of(...) creates an immutable list with predefined values.
- Wrapping it inside new ArrayList<>() ensures mutability, so you can add or remove students later.

💡 If you directly used List.of(), you wouldn't be able to modify the list (students.add(student); would fail).
 */
