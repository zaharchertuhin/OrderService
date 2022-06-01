package ru.cmit.orderservice.service.api;

import lombok.NonNull;
import ru.cmit.orderservice.controller.dto.order.TaskCreateRequest;
import ru.cmit.orderservice.controller.dto.order.TaskResponse;
import ru.cmit.orderservice.controller.dto.order.TaskUpdateRequest;
import ru.cmit.orderservice.entity.TaskEntity;

import java.util.List;

public interface OrderService {


    TaskEntity getOrderEntityById(@NonNull Long id);

    TaskResponse getOrderById(@NonNull Long id);

    List<TaskEntity> getAllOrders();

    void deleteOrderById(@NonNull Long id);


}
