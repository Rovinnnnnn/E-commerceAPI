package com.rovinn.backendfrontends.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderItemRequestDTO{
    @NotNull(message = "Product id is required")
    private Long productId;

    @NotNull (message = "Quantity is required")
    @Valid
    private Integer quantity;
}
