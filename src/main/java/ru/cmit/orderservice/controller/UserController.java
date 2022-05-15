package ru.cmit.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cmit.orderservice.controller.dto.OrderCreateRequest;
import ru.cmit.orderservice.controller.dto.OrderResponse;
import ru.cmit.orderservice.entity.UserEntity;
import ru.cmit.orderservice.service.api.OrderService;
import ru.cmit.orderservice.service.api.UserService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Validated
public class UserController {

    private final UserService userService;


    @GetMapping("/id/{id}")
    public UserEntity getUserById(@PathVariable @Positive Long id) {
        return userService.getUSerEntityById(id);
    }
}
