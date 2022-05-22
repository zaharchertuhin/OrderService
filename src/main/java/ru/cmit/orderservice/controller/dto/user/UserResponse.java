package ru.cmit.orderservice.controller.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;

    private String login;

    private String name;

    private String surname;

    private LocalDate dateOfBirth;
}
