package com.rovinn.backendfrontends.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponseDTO {
    private Long id;
    private OrderStatus orderStatus;
    private String paymentMethod;
    private LocalDateTime createAt;
    private List<OrderItemResponseDTO> orderItems;
}
