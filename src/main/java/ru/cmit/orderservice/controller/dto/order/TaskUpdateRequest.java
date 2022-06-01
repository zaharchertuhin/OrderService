package ru.cmit.orderservice.controller.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskUpdateRequest {
    @JsonProperty(required = true)
    @NotBlank
    private String taskBody;

}
