package ru.cmit.orderservice.controller.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponse extends TaskResponse {

    private Long id;

    private String answer;
}
