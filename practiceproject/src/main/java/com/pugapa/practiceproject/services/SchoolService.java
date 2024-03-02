package com.pugapa.practiceproject.services;

import com.pugapa.practiceproject.school.SchoolDto;
import com.pugapa.practiceproject.school.SchoolMapper;
import com.pugapa.practiceproject.repositories.SchoolRepository;

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
