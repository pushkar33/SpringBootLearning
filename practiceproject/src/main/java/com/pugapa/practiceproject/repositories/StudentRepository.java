package com.pugapa.practiceproject.repositories;

import com.pugapa.practiceproject.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer>{
}
