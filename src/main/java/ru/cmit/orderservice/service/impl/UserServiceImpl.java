package ru.cmit.orderservice.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cmit.orderservice.entity.UserEntity;
import ru.cmit.orderservice.repository.UserRepository;
import ru.cmit.orderservice.service.api.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity getUSerEntityById(@NonNull Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Пользователь с id: " + id + " не найден"));
    }
}

