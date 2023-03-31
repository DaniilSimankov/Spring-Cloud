package ru.education.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.education.clients.CoursesClient;
import ru.education.clients.UsersClient;
import ru.education.dto.EducationDto;

@RestController
public class EducationController {

    @Autowired
    private CoursesClient coursesClient;

    @Autowired
    private UsersClient usersClient;

    @GetMapping("/education")
    public ResponseEntity<EducationDto> getEducation() {
        return ResponseEntity.ok(EducationDto.builder()
                .courses(coursesClient.getCourses())
                .users(usersClient.getUsers())
                .build());
    }
}


