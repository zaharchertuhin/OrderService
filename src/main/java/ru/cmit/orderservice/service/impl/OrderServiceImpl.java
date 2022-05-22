package ru.cmit.orderservice.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cmit.orderservice.controller.dto.order.OrderCreateRequest;
import ru.cmit.orderservice.controller.dto.order.OrderResponse;
import ru.cmit.orderservice.controller.dto.order.OrderUpdateRequest;
import ru.cmit.orderservice.entity.OrderEntity;
import ru.cmit.orderservice.mapper.OrderMapper;
import ru.cmit.orderservice.repository.OrderRepository;
import ru.cmit.orderservice.service.api.OrderService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class    OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderResponse createOrder(@NonNull OrderCreateRequest createRequest) {
        OrderEntity orderEntityForSave = orderMapper.toEntity(createRequest);
        OrderEntity savedOrder = orderRepository.save(orderEntityForSave);
        return orderMapper.toOrderResponse(savedOrder);
    }

    @Override
    public OrderEntity getOrderEntityById(@NonNull Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Order with id : " + id + " not found"));
    }

    @Override
    public OrderResponse getOrderById(@NonNull Long id) {
        OrderEntity orderFromRepository = getOrderEntityById(id);
        return orderMapper.toOrderResponse(orderFromRepository);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<OrderEntity> list = orderRepository.findAll();
        return orderMapper.toListOrderResponse(list);
    }

    @Override
    public List<OrderResponse> getOrdersByUsername(@NonNull String username) {
        List<OrderEntity> all = orderRepository.findAllByUsername(username);
        return orderMapper.toListOrderResponse(all);
    }

    @Override
    public void deleteOrderById(@NonNull Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderResponse updateOrder(@NonNull Long id,
                                     @NonNull OrderUpdateRequest updateRequest) {
        OrderEntity orderForUpdate = orderMapper.toEntity(id, updateRequest);
        return orderMapper.toOrderResponse(orderRepository.save(orderForUpdate));
    }
}
