package ru.cmit.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cmit.orderservice.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByLogin(String login);

    List<UserEntity> findAll();
}

