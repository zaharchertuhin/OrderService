package ru.cmit.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cmit.orderservice.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
