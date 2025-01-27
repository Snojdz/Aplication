package com.pyszne.pyszne.controller;
import com.pyszne.pyszne.model.Dishes;
import com.pyszne.pyszne.repository.DishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/dishes")
public class DishesController {
    @Autowired
    private DishesRepository dishesRepository;

    // Pobierz listę wszystkich dań
    @GetMapping
    public List<Dishes> getAllDishes() {
        return dishesRepository.findAll();
    }

    // Pobierz szczegóły dania po ID
    @GetMapping("/{id}")
    public Optional<Dishes> getDishById(@PathVariable Long id) {
        return dishesRepository.findById(id);
    }

    // Pobierz listę dań dla określonej restauracji
    @GetMapping("/restaurant/{restaurantId}")
    public List<Dishes> getDishesByRestaurant(@PathVariable Long restaurantId) {
        return dishesRepository.findByRestaurantRestaurantId(restaurantId);
    }

    // Dodaj nowe danie (tylko dla admina lub restauratora)
    @PostMapping
    public Dishes addDish(@RequestBody Dishes dish) {
        return dishesRepository.save(dish);
    }

    @GetMapping("/search")
    public List<Dishes> getDishesByName(@RequestParam String name) {
        return dishesRepository.findByName(name);
    }
    @GetMapping("/available")
    public List<Dishes> getAvailableDishes() {
        return dishesRepository.findByAvailableTrue();
    }
    @GetMapping("/category")
    public List<Dishes> getDishesByCategory(@RequestParam String category) {
        return dishesRepository.findByCategory(category);
    }
    @GetMapping("/price/less")
    public List<Dishes> getDishesByPriceLessThan(@RequestParam Double price) {
        return dishesRepository.findByPriceLessThan(price);
    }
    @GetMapping("/price/more")
    public List<Dishes> getDishesByPriceGreaterThan(@RequestParam Double price) {
        return dishesRepository.findByPriceGreaterThan(price);
    }

}
