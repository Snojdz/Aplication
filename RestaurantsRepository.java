package com.pyszne.pyszne.repository;

import com.pyszne.pyszne.model.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantsRepository extends JpaRepository<Restaurants, Long> {
    List<Restaurants> findByName(String name);
    // Wyszukaj restauracje o ocenach powyżej określonej wartości
    List<Restaurants> findByRatingGreaterThan(Double rating);

    // Wyszukaj restauracje w określonej lokalizacji (np. po adresie)
    List<Restaurants> findByAddressContaining(String location);
}
