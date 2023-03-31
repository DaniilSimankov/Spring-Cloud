package ru.users.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.users.dto.UserDto;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {
    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){
        log.info("Get response for users");
        return ResponseEntity.ok(Arrays.asList(
                UserDto.builder().firstName("User 1").lastName("User 1").build(),
                UserDto.builder().firstName("User 2").lastName("User 2").build(),
                UserDto.builder().firstName("User 3").lastName("User 3").build(),
                UserDto.builder().firstName("User 4").lastName("User 4").build())
        );

    }
}
