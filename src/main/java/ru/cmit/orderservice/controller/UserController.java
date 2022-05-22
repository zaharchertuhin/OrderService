package ru.cmit.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cmit.orderservice.controller.dto.user.UserResponse;
import ru.cmit.orderservice.service.api.UserService;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Validated
public class UserController {

    private final UserService userService;


    @GetMapping("/id/{id}")
    public UserResponse getUserById(@PathVariable @Positive Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/login/{login}")
    public UserResponse getUserByLogin(@NotBlank String login){
        return userService.getUserByLogin(login);
    }

    @GetMapping("/all")
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }
}
