package com.pugapa.practiceproject.student;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public record StudentDto(

        @NotEmpty(message = "Firstname should not be empty")
         String firstname,

         @NotEmpty(message = "Lastname should not be empty")
         String lastname,

         String email,

         Integer schoolId
) {
}
