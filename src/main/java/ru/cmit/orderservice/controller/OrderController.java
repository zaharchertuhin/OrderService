package ru.cmit.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cmit.orderservice.controller.dto.order.OrderCreateRequest;
import ru.cmit.orderservice.controller.dto.order.OrderResponse;
import ru.cmit.orderservice.service.api.OrderService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@Validated
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/all")
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/create")
    public OrderResponse savedOrder(@RequestBody @Valid OrderCreateRequest createRequest) {
        return orderService.createOrder(createRequest);
    }

    @GetMapping("/id/{id}")
    public OrderResponse getOrderById(@PathVariable @Positive Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/user/{username}")
    public List<OrderResponse> getOrdersByUsername(@PathVariable String username) {
        return orderService.getOrdersByUsername(username);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }
//
//    @PutMapping("/update/{id}")
//    public OrderEntity updateOrder(@PathVariable Long id,
//                                   @RequestBody OrderEntity order) {
//        return orderService.updateOrder(id, order);
//    }
}
