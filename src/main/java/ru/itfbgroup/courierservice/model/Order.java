package ru.itfbgroup.courierservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    private Long id;
    private Long customerId;
    private Long restaurantId;
    private String address;
    private LocalDateTime creationDate;
    private OrderStatus status;
    private String doneDate;
    private double amount;
}
