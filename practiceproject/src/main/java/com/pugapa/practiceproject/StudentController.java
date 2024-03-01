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
    public StudentResponseDto createStudent(@RequestBody StudentDto dto)
    {
      Student student= studentRepository.save(toStudent(dto));
      return toStudentResponseDto(student);
    }

    private Student toStudent(StudentDto dto)
    {
        Student student=new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        var school=new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }

    private StudentResponseDto toStudentResponseDto(Student student)
    {
        return new StudentResponseDto(student.getFirstname(),student.getLastname(),student.getEmail());
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
