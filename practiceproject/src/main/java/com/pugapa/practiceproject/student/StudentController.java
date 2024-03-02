package com.pugapa.practiceproject.student;

import com.pugapa.practiceproject.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
      this.studentService=studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(@Valid @RequestBody StudentDto dto)
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp)
    {
         var errors=new HashMap<String,String>();
         exp.getBindingResult().getAllErrors().forEach(error->{
             var fieldName=((FieldError)error).getField();
             var errorMessage=error.getDefaultMessage();
             errors.put(fieldName,errorMessage);
         });
         return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
