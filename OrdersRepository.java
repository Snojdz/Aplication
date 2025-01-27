package com.pyszne.pyszne.repository;

import com.pyszne.pyszne.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    // Wyszukaj zamówienia po statusie
    List<Orders> findByStatus(String status);

    // Wyszukaj zamówienia z określonego przedziału czasowego
    List<Orders> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Wyszukaj zamówienia użytkownika po jego ID
    List<Orders> findByUserUserId(Long userId);
}
