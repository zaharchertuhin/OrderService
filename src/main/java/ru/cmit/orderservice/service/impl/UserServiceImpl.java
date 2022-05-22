package ru.cmit.orderservice.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cmit.orderservice.controller.dto.user.UserResponse;
import ru.cmit.orderservice.entity.UserEntity;
import ru.cmit.orderservice.mapper.UserMapper;
import ru.cmit.orderservice.repository.UserRepository;
import ru.cmit.orderservice.service.api.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserEntity getUserEntityById(@NonNull Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Пользователь с id: " + id + " не найден"));
    }

    @Override
    public UserResponse getUserById(@NonNull Long id) {
        UserEntity userFromRepository = getUserEntityById(id);
        return userMapper.toUserResponse(userFromRepository);

    }

    @Override
    public UserEntity getUserEntityByLogin(@NonNull String login) {
        return userRepository.findByLogin(login).orElseThrow(() -> new RuntimeException("Пользователь " + login + " не найден"));
    }

    @Override
    public UserResponse getUserByLogin(@NonNull String login) {
        UserEntity userFromRepository = getUserEntityByLogin(login);
        return userMapper.toUserResponse(userFromRepository);
    }

    @Override
    public List<UserResponse> getAllUsers(){
        List<UserEntity> list = userRepository.findAll();
        return userMapper.toListUserResponse(list);
    }
}

