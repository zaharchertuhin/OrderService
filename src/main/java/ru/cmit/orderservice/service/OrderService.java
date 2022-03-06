package ru.cmit.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cmit.orderservice.entity.OrderEntity;
import ru.cmit.orderservice.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderEntity createOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    public OrderEntity getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Order with id : " + id + " not found"));
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<OrderEntity> getOrdersByUsername(String username) {
        return orderRepository.findAllByUsername(username);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    public OrderEntity updateOrder(Long id, OrderEntity order) {
        OrderEntity orderFromDB = getOrderById(id);

        orderFromDB.setDescription(order.getDescription());
        orderFromDB.setUsername(order.getUsername());

        return orderRepository.save(orderFromDB);
    }
}
