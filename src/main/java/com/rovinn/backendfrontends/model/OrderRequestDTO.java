package com.rovinn.backendfrontends.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
   @NotBlank(message = "Payment method is required")
    private String paymentMethod;

   @NotEmpty(message = "Order must have at least one item")
    @Valid
    private List<OrderItemRequestDTO> orderItems;

}
