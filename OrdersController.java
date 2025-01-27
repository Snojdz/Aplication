package com.pyszne.pyszne.controller;
import com.pyszne.pyszne.model.Orders;
import com.pyszne.pyszne.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersRepository ordersRepository;

    // Pobierz listę zamówień użytkownika
    @GetMapping("/user/{userId}")
    public List<Orders> getOrdersByUser(@PathVariable Long userId) {
        return ordersRepository.findByUserUserId(userId);
    }

    // Dodaj nowe zamówienie
    @PostMapping
    public Orders placeOrder(@RequestBody Orders order) {
        return ordersRepository.save(order);
    }

    // Zaktualizuj status zamówienia (np. "W realizacji", "Dostarczone")
    @PutMapping("/{id}")
    public Orders updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        Orders order = ordersRepository.findById(id).orElseThrow();
        order.setStatus(status);
        return ordersRepository.save(order);
    }
}
