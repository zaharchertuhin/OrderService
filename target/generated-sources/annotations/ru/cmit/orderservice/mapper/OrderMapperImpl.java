package ru.cmit.orderservice.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.cmit.orderservice.controller.dto.order.TaskResponse;
import ru.cmit.orderservice.entity.TaskEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-01T16:49:10+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public TaskResponse toOrderResponse(TaskEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        TaskResponse taskResponse = new TaskResponse();

        taskResponse.setId( orderEntity.getId() );
        taskResponse.setTaskBody( orderEntity.getTaskBody() );

        return taskResponse;
    }
}
