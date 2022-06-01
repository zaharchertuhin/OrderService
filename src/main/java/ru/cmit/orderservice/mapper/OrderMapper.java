package ru.cmit.orderservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.cmit.orderservice.config.MappersConfig;
import ru.cmit.orderservice.controller.dto.order.AnswerResponse;
import ru.cmit.orderservice.controller.dto.order.TaskCreateRequest;
import ru.cmit.orderservice.controller.dto.order.TaskResponse;
import ru.cmit.orderservice.controller.dto.order.TaskUpdateRequest;
import ru.cmit.orderservice.entity.OrderEntity;
import ru.cmit.orderservice.entity.TaskEntity;

import java.util.List;

@Mapper(config = MappersConfig.class)
public interface OrderMapper {

    TaskResponse toOrderResponse(TaskEntity orderEntity);


}
