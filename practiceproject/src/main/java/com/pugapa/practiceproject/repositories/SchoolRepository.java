package com.pugapa.practiceproject.repositories;

import com.pugapa.practiceproject.school.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Integer> {
}
