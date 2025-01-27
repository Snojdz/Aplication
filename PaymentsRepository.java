package com.pyszne.pyszne.repository;

import com.pyszne.pyszne.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface PaymentsRepository extends JpaRepository<Payments, Long> {
    // Wyszukaj płatności po statusie
    List<Payments> findByStatus(String status);

    // Wyszukaj płatności po metodzie płatności
    List<Payments> findByPaymentMethod(String paymentMethod);

    // Wyszukaj płatności w określonym zakresie dat
    List<Payments> findByPaymentDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    // Wyszukaj platnosci po id uzytkownika
    List<Payments> findByOrderUserUserId(Long userId);

}
