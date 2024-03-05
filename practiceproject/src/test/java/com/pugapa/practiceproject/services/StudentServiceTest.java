package com.pugapa.practiceproject.services;

import com.pugapa.practiceproject.repositories.StudentRepository;
import com.pugapa.practiceproject.student.Student;
import com.pugapa.practiceproject.student.StudentDto;
import com.pugapa.practiceproject.student.StudentMapper;
import com.pugapa.practiceproject.student.StudentResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    // service want to test
    @InjectMocks
    private StudentService studentService;

    // declare the dependencies
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_student()
    {
        // Given
        StudentDto dto=new StudentDto("John","Lemon","john@mail.com",1);

        Student student=new Student("John","Lemon","john@mail.com",18);

        // Mock the calls
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(student);
        when(studentMapper.toStudentResponseDto(student)).thenReturn(new StudentResponseDto("John","Lemon","john@mail.com"));

        // When
        StudentResponseDto responseDto=studentService.saveStudent(dto);

        // Then
        assertEquals(dto.firstname(),responseDto.firstname());
        assertEquals(dto.lastname(),responseDto.lastname());
        assertEquals(dto.email(),responseDto.email());

        verify(studentMapper,times(1)).toStudent(dto);
        verify(studentRepository,times(1)).save(student);
        verify(studentMapper,times(1)).toStudentResponseDto(student);
    }

    @Test
    public void should_find_all_students()
    {
        // Given
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student("John","Lemon","john@mail.com",18));

        when(studentRepository.findAll()).thenReturn(studentList);
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto("John","Lemon","john@mail.com"));

        // When
        List<StudentResponseDto> responseDtos=studentService.getStudents();

        // Then
        assertEquals(studentList.size(),responseDtos.size());

        verify(studentRepository,times(1)).findAll();
    }


    @Test
    public void should_find_student_by_id()
    {
        Integer studentId=1;
        Student student=new Student("John","Lemon","john@mail.com",18);

        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(student)).thenReturn(new StudentResponseDto("John","Lemon","john@mail.com"));

        StudentResponseDto dto=studentService.getStudentById(studentId);

        assertEquals(dto.firstname(),student.getFirstname());
        assertEquals(dto.lastname(),student.getLastname());
        assertEquals(dto.email(),student.getEmail());

        verify(studentRepository,times(1)).findById(studentId);
    }

    @Test
    public void should_find_student_by_name()
    {
        String name="John";
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student("John","Lemon","john@mail.com",18));

        when(studentRepository.findAllByFirstnameContaining(name)).thenReturn(studentList);
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto("John","Lemon","john@mail.com"));

        List<StudentResponseDto> studentResponseList=studentService.getStudentsByName(name);

        assertEquals(studentList.size(),studentResponseList.size());
        verify(studentRepository,times(1)).findAllByFirstnameContaining(name);
    }
}