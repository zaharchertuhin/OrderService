package ru.cmit.orderservice.service.api;

import lombok.NonNull;
import ru.cmit.orderservice.entity.UserEntity;

public interface UserService {
    UserEntity getUSerEntityById(@NonNull Long id);
}
