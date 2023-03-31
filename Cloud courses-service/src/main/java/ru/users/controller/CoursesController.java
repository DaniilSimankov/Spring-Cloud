package ru.users.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.users.dto.CoursesDto;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/courses")
@Slf4j
public class CoursesController {
    @GetMapping
    public ResponseEntity<List<CoursesDto>> getCourses(){
        log.info("Get response for courses");
        return ResponseEntity.ok(Arrays.asList(
                CoursesDto.builder().title("Course 1").id(1L).build(),
                CoursesDto.builder().title("Course 2").id(2L).build(),
                CoursesDto.builder().title("Course 3").id(3L).build(),
                CoursesDto.builder().title("Course 4").id(4L).build())
        );

    }
}
