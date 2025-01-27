package com.pyszne.pyszne.controller;
import com.pyszne.pyszne.model.Restaurants;
import com.pyszne.pyszne.repository.RestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantsController {
    @Autowired
    private RestaurantsRepository restaurantsRepository;

    // Pobierz listę wszystkich restauracji
    @GetMapping
    public List<Restaurants> getAllRestaurants() {
        return restaurantsRepository.findAll();
    }

    // Pobierz szczegóły restauracji po ID
    @GetMapping("/{id}")
    public Optional<Restaurants> getRestaurantById(@PathVariable Long id) {
        return restaurantsRepository.findById(id);
    }

    // Wyszukaj restauracje po nazwie
    @GetMapping("/search")
    public List<Restaurants> searchRestaurantsByName(@RequestParam String name) {
        return restaurantsRepository.findByName(name);
    }

    // Dodaj nową restaurację (tylko dla admina)
    @PostMapping
    public Restaurants addRestaurant(@RequestBody Restaurants restaurant) {
        return restaurantsRepository.save(restaurant);
    }
    // Wyszukaj restauracje o ocenach powyżej określonej wartości
    @GetMapping("/ratings")
    public List<Restaurants> searchRestaurantsByRating(@RequestParam Double rating) {
        return restaurantsRepository.findByRatingGreaterThan(rating);
    }

    // Wyszukaj restauracje w określonej lokalizacji (np. po adresie)
    @GetMapping("/location")
    public List<Restaurants> searchRestaurantsByLocation(@RequestParam String location) {
        return restaurantsRepository.findByAddressContaining(location);
    }
}
