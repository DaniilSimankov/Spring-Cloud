package ru.education.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.education.dto.CoursesDto;

import java.util.List;

@FeignClient("courses-service")
public interface CoursesClient {
    @RequestMapping("/courses")
    List<CoursesDto> getCourses();
}


