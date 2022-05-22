package ru.cmit.orderservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.cmit.orderservice.config.MappersConfig;
import ru.cmit.orderservice.controller.dto.order.OrderCreateRequest;
import ru.cmit.orderservice.controller.dto.order.OrderResponse;
import ru.cmit.orderservice.controller.dto.order.OrderUpdateRequest;
import ru.cmit.orderservice.entity.OrderEntity;

import java.util.List;

@Mapper(config = MappersConfig.class)
public interface OrderMapper {

    OrderResponse toOrderResponse(OrderEntity orderEntity);

    @Mapping(target = "id", ignore = true)
    OrderEntity toEntity(OrderCreateRequest orderCreateRequest);

    OrderEntity toEntity(Long id, OrderUpdateRequest orderUpdateRequest);


    List<OrderResponse> toListOrderResponse(List<OrderEntity> list);
}
