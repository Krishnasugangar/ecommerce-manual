package com.example.ecommercemanual.repository;

import com.example.ecommercemanual.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom query to find all orders placed by a specific user ID
    List<Order> findByUserId(Long userId);
}