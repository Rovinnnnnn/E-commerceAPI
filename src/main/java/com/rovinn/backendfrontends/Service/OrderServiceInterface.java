package com.rovinn.backendfrontends.Service;

import com.rovinn.backendfrontends.model.OrderRequestDTO;
import com.rovinn.backendfrontends.model.OrderResponseDTO;
import com.rovinn.backendfrontends.model.OrderStatus;

import java.util.List;

public interface OrderServiceInterface {
    OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO,String userEmail);
    List<OrderResponseDTO> getAllOrders();
    OrderResponseDTO getOrderById(Long id);
    OrderResponseDTO updateStatusById(Long id, OrderStatus newStatus);
}
