package com.pyszne.pyszne.controller;
import com.pyszne.pyszne.model.Payments;
import com.pyszne.pyszne.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/payments")
public class PaymentsController {
    @Autowired
    private PaymentsRepository paymentsRepository;

    // Pobierz wszystkie płatności użytkownika
    @GetMapping("/user/{userId}")
    public List<Payments> getPaymentsByUser(@PathVariable Long userId) {
        return paymentsRepository.findByOrderUserUserId(userId);
    }

    // Dodaj nową płatność
    @PostMapping
    public Payments processPayment(@RequestBody Payments payment) {
        return paymentsRepository.save(payment);
    }

    // Pobierz szczegóły płatności po ID
    @GetMapping("/{id}")
    public Payments getPaymentById(@PathVariable Long id) {
        return paymentsRepository.findById(id).orElseThrow();
    }
}
