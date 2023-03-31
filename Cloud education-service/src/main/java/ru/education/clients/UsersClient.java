package ru.education.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.education.dto.UserDto;

import java.util.List;

@FeignClient("users-service")
public interface UsersClient {
    @RequestMapping("/users")
    List<UserDto> getUsers();
}


