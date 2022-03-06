package ru.cmit.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cmit.orderservice.entity.OrderEntity;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findAllByUsername(String username);
}
