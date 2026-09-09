package com.rovinn.backendfrontends.Repository;

import com.rovinn.backendfrontends.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
