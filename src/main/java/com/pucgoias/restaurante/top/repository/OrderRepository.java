package com.pucgoias.restaurante.top.repository;

import com.pucgoias.restaurante.top.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
