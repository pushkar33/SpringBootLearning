package com.pugapa.practiceproject.student;

import jakarta.persistence.Column;

public record StudentDto(
         String firstname,

         String lastname,

         String email,

         Integer schoolId
) {
}