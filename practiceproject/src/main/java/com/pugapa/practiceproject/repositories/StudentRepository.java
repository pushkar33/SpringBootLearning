package com.pugapa.practiceproject.repositories;

import com.pugapa.practiceproject.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

    List<Student> findAllByFirstnameContaining(String firstname);

}
