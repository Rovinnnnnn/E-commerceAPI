package com.rovinn.backendfrontends.Controller;

import com.rovinn.backendfrontends.Service.OrderServiceInterface;
import com.rovinn.backendfrontends.model.OrderRequestDTO;
import com.rovinn.backendfrontends.model.OrderResponseDTO;
import com.rovinn.backendfrontends.model.OrderStatus;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderServiceInterface orderService;
    public OrderController(OrderServiceInterface orderService) {
        this.orderService = orderService;
    }
    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO, Authentication authentication) {
        String userEmail = authentication.getName();
        return ResponseEntity.ok(orderService.createOrder(orderRequestDTO, userEmail));
    }
    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
    @GetMapping ("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<OrderResponseDTO>  updateOrder(@PathVariable Long id, @Valid @RequestBody OrderStatus orderStatus) {
        return ResponseEntity.ok(orderService.updateStatusById(id, orderStatus));
    }
 }
