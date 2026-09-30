package com.rovinn.backendfrontends.Repository;

import com.rovinn.backendfrontends.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rovinn.backendfrontends.model.User;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);

    User User(User user);

    List<Order> user(User user);
}
