package ru.cmit.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cmit.orderservice.entity.OrderEntity;
import ru.cmit.orderservice.entity.TaskEntity;

import java.util.List;

public interface OrderRepository extends JpaRepository<TaskEntity, Long> {

}
