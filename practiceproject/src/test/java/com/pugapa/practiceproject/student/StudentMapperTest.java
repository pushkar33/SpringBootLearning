package com.pugapa.practiceproject.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

   private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper=new StudentMapper();
    }

    @Test
   public void shouldMapStudentDtoToStudent()
   {
      StudentDto dto=new StudentDto("John","Lemon","john@mail.com",1);
      Student student=mapper.toStudent(dto);

       assertEquals(dto.firstname(),student.getFirstname());
       assertEquals(dto.lastname(),student.getLastname());
       assertEquals(dto.email(),student.getEmail());
       assertNotNull(student.getSchool());
       assertEquals(dto.schoolId(),student.getSchool().getId());
   }

   @Test
   public void should_map_studentDto_to_student_when_studentDto_is_null()
   {
       var msg=assertThrows(NullPointerException.class,()->mapper.toStudent(null));
       assertEquals( "The Student Dto Should Not Be Null",msg.getMessage());
   }

   @Test
    public void shouldMapStudentToStudentResponseDto()
   {
       // Given
       Student student=new Student("Gauri","Goyal","Gauri23@mail.com",18);

       // When
       StudentResponseDto dto=mapper.toStudentResponseDto(student);

       // Then
       assertEquals(student.getFirstname(),dto.firstname());
       assertEquals(student.getLastname(),dto.lastname());
       assertEquals(student.getEmail(),dto.email());
   }

}