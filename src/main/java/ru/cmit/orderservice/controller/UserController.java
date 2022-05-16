package ru.cmit.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cmit.orderservice.entity.UserEntity;
import ru.cmit.orderservice.service.api.UserService;

import javax.validation.constraints.Positive;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Validated
public class UserController {

    private final UserService userService;


    @GetMapping("/id/{id}")
    public UserEntity getUserById(@PathVariable @Positive Long id) {
        return userService.getUserEntityById(id);
    }
}
