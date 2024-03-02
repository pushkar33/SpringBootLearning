package com.pugapa.practiceproject.services;

import com.pugapa.practiceproject.SchoolDto;
import com.pugapa.practiceproject.SchoolMapper;
import com.pugapa.practiceproject.repositories.SchoolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository,SchoolMapper schoolMapper)
    {
        this.schoolRepository=schoolRepository;
        this.schoolMapper=schoolMapper;
    }

    public SchoolDto create(SchoolDto dto)
    {
        var school=schoolMapper.toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }

    public List<SchoolDto> getSchools()
    {
        return schoolRepository.findAll().stream().map(schoolMapper::toSchoolDto).collect(Collectors.toList());
    }


}
