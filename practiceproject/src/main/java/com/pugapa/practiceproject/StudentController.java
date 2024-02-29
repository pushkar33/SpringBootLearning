package com.pugapa.practiceproject;

import com.pugapa.practiceproject.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository)
    {
        this.studentRepository=studentRepository;
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student)
    {
        return  studentRepository.save(student);
    }

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student getStudentById(@PathVariable("student-id") Integer id)
    {
        return studentRepository.findById(id).orElse(new Student());
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> getStudentsByName(@PathVariable("student-name") String name)
    {
        return studentRepository.findAllByFirstnameContaining(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("student-id") Integer id)
    {
        studentRepository.deleteById(id);
    }
}