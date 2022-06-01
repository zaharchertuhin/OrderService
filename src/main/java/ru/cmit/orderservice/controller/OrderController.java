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
import ru.cmit.orderservice.controller.dto.order.TaskCreateRequest;
import ru.cmit.orderservice.controller.dto.order.TaskResponse;
import ru.cmit.orderservice.entity.TaskEntity;
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
    public List<TaskEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/task/{id}")
    public TaskEntity getTask(@PathVariable @Positive Long id) {
        return orderService.getOrderEntityById(id);
    }

    @GetMapping("/id/{id}")
    public TaskResponse getOrderById(@PathVariable @Positive Long id) {
        return orderService.getOrderById(id);
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
