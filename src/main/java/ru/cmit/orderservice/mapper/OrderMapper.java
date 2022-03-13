package ru.cmit.orderservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.cmit.orderservice.config.MappersConfig;
import ru.cmit.orderservice.controller.dto.OrderCreateRequest;
import ru.cmit.orderservice.controller.dto.OrderResponse;
import ru.cmit.orderservice.entity.OrderEntity;

@Mapper(config = MappersConfig.class)
public interface OrderMapper {

    OrderResponse toOrderResponse(OrderEntity orderEntity);

    @Mapping(target = "id", ignore = true)
    OrderEntity toEntity(OrderCreateRequest orderCreateRequest);
}