package ru.cmit.orderservice.service.api;

import lombok.NonNull;
import ru.cmit.orderservice.controller.dto.OrderCreateRequest;
import ru.cmit.orderservice.controller.dto.OrderResponse;
import ru.cmit.orderservice.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(@NonNull OrderCreateRequest createRequest);

    OrderEntity getOrderEntityById(@NonNull Long id);

    OrderResponse getOrderById(@NonNull Long id);

    List<OrderEntity> getAllOrders();

    List<OrderEntity> getOrdersByUsername(@NonNull String username);

    void deleteOrderById(@NonNull Long id);

    OrderEntity updateOrder(@NonNull Long id,
                            @NonNull OrderEntity order);
}