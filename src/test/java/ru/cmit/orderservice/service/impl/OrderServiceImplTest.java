package ru.cmit.orderservice.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.cmit.orderservice.controller.dto.order.OrderCreateRequest;
import ru.cmit.orderservice.controller.dto.order.OrderResponse;
import ru.cmit.orderservice.controller.dto.order.OrderUpdateRequest;
import ru.cmit.orderservice.entity.OrderEntity;
import ru.cmit.orderservice.repository.OrderRepository;
import ru.cmit.orderservice.service.api.OrderService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class OrderServiceImplTest {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;


    public static final String DESCRIPTION ="test-order";
    public static final String USERNAME = "test-user";



    public Long id = null;

    @BeforeEach
    void setUp() {
        OrderEntity order = new OrderEntity();
        order.setDescription(DESCRIPTION);
        order.setUsername(USERNAME);
        id = orderRepository.save(order).getId();
    }

    @AfterEach
    void tearDown() {
        orderRepository.deleteAll();
    }

    @Test
    void createOrder() {
        String createDescription = "new test";
        String createUsername = "new test";
        OrderCreateRequest createRequest = new OrderCreateRequest(createDescription, createUsername);
        Long createdId = orderService.createOrder(createRequest).getId();
        assertEquals(orderService.getOrderById(createdId).getDescription(), createDescription);
        assertEquals(orderService.getOrderById(createdId).getUsername(), createUsername);
        orderRepository.deleteById(createdId);
    }

    @Test
    void getOrderEntityById() {
        OrderEntity orderFromService = orderService.getOrderEntityById(id);
        assertEquals(orderFromService.getDescription(), DESCRIPTION);
        assertEquals(orderFromService.getUsername(), USERNAME);
    }

    @Test
    void getOrderEntityByIdException(){
        assertThrows(RuntimeException.class, ()-> orderService.getOrderEntityById(455l));
    }

    @Test
    void getOrderById() {
        OrderResponse orderFromService = orderService.getOrderById(id);
        assertEquals(orderFromService.getDescription(), DESCRIPTION);
        assertEquals(orderFromService.getUsername(), USERNAME);
    }

    @Test
    void getOrderByIdException() {
        assertThrows(RuntimeException.class, ()-> orderService.getOrderById(222l));

    }

    @Test
    void getAllOrders() {
        List<OrderResponse> allOrders = orderService.getAllOrders();
        assertEquals(allOrders.size(), 1);
    }

    @Test
    void getOrdersByUsername() {
        assertEquals(orderService.getOrdersByUsername(USERNAME).size(),1);
    }

    @Test
    void deleteOrderById() {
        String createDescription = "new test";
        String createUsername = "new test";
        OrderCreateRequest createRequest = new OrderCreateRequest(createDescription, createUsername);
        Long orderId = orderService.createOrder(createRequest).getId();
        orderService.deleteOrderById(orderId);
        assertThrows(RuntimeException.class, () -> orderService.getOrderById(orderId));

    }

    @Test
    void updateOrder() {
        String createDescription = "new test";
        String createUsername = "new test";
        orderService.updateOrder(id, new OrderUpdateRequest(createDescription, createUsername));
        assertEquals(orderService.getOrderById(id).getDescription(), createDescription);
        assertEquals(orderService.getOrderById(id).getUsername(), createUsername);

    }
}