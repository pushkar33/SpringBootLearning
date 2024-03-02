package com.pugapa.practiceproject.services;

import com.pugapa.practiceproject.Student;
import com.pugapa.practiceproject.StudentDto;
import com.pugapa.practiceproject.StudentMapper;
import com.pugapa.practiceproject.StudentResponseDto;
import com.pugapa.practiceproject.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository,StudentMapper studentMapper)
    {
        this.studentRepository=studentRepository;
        this.studentMapper=studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto dto)
    {
        Student student= studentRepository.save(studentMapper.toStudent(dto));
        return studentMapper.toStudentResponseDto(student);
    }

    public List<StudentResponseDto> getStudents()
    {
        return studentRepository.findAll().stream().map(studentMapper :: toStudentResponseDto).collect(Collectors.toList());
    }

    public StudentResponseDto getStudentById(Integer id)
    {
       return studentRepository.findById(id).map(studentMapper :: toStudentResponseDto).orElse(null);
    }

    public List<StudentResponseDto> getStudentsByName(String name)
    {
        return studentRepository.findAllByFirstnameContaining(name).stream().map(studentMapper :: toStudentResponseDto).collect(Collectors.toList());
    }

    public void deleteStudent(Integer id)
    {
        studentRepository.deleteById(id);
    }
}
