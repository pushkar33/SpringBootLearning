package com.pugapa.practiceproject.student;


import com.pugapa.practiceproject.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto)
    {
        if(dto==null)
        {
            throw new NullPointerException("The Student Dto Should Not Be Null");
        }
        Student student=new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        var school=new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student)
    {
        return new StudentResponseDto(student.getFirstname(),student.getLastname(),student.getEmail());
    }

}
