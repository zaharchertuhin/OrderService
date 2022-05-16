package ru.cmit.orderservice.service.api;

import lombok.NonNull;
import ru.cmit.orderservice.controller.UserResponse;
import ru.cmit.orderservice.entity.UserEntity;

public interface UserService {
    UserEntity getUserEntityById(@NonNull Long id);

    UserResponse getUserById(@NonNull Long id);
}
