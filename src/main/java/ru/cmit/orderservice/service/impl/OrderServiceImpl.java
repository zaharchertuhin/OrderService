package ru.cmit.orderservice.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cmit.orderservice.controller.dto.order.TaskCreateRequest;
import ru.cmit.orderservice.controller.dto.order.TaskResponse;
import ru.cmit.orderservice.controller.dto.order.TaskUpdateRequest;
import ru.cmit.orderservice.entity.TaskEntity;
import ru.cmit.orderservice.mapper.OrderMapper;
import ru.cmit.orderservice.repository.OrderRepository;
import ru.cmit.orderservice.service.api.OrderService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public TaskEntity getOrderEntityById(@NonNull Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Task with id : " + id + " not found"));
    }

    @Override
    public TaskResponse getOrderById(@NonNull Long id) {
        TaskEntity orderFromRepository = getOrderEntityById(id);
        return orderMapper.toOrderResponse(orderFromRepository);
    }

    @Override
    public List<TaskEntity> getAllOrders() {

        return orderRepository.findAll();
    }



    @Override
    public void deleteOrderById(@NonNull Long id) {
        orderRepository.deleteById(id);
    }

}
