package com.pugapa.practiceproject;

import com.pugapa.practiceproject.repositories.StudentRepository;
import com.pugapa.practiceproject.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
      this.studentService=studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(@RequestBody StudentDto dto)
    {
     return studentService.saveStudent(dto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> getStudents()
    {
        return studentService.getStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto getStudentById(@PathVariable("student-id") Integer id)
    {
        return studentService.getStudentById(id);
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> getStudentsByName(@PathVariable("student-name") String name)
    {
        return studentService.getStudentsByName(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("student-id") Integer id)
    {
        studentService.deleteStudent(id);
    }
}
