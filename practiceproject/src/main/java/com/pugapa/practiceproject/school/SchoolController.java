package com.pugapa.practiceproject.school;

import com.pugapa.practiceproject.services.SchoolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

  private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService)
    {
        this.schoolService=schoolService;
    }

   @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto dto)
   {
       return schoolService.create(dto);
   }

   @GetMapping("/schools")
   public List<SchoolDto> getSchools()
   {
       return schoolService.getSchools();
   }

}
