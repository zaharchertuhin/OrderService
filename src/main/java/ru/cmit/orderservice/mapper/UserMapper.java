package ru.cmit.orderservice.mapper;

import org.mapstruct.Mapper;
import ru.cmit.orderservice.config.MappersConfig;
import ru.cmit.orderservice.controller.UserResponse;
import ru.cmit.orderservice.entity.UserEntity;

@Mapper(config = MappersConfig.class)
public interface UserMapper {
    UserResponse toUserResponse(UserEntity userFromRepository) ;
}
