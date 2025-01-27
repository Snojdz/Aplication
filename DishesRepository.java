package com.pyszne.pyszne.repository;

import com.pyszne.pyszne.model.Dishes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DishesRepository extends JpaRepository<Dishes, Long>{
    // Wyszukaj dania po nazwie
    List<Dishes> findByName(String name);

    // Wyszukaj dania, które są dostępne
    List<Dishes> findByAvailableTrue();

    // Wyszukaj dania z danej kategorii
    List<Dishes> findByCategory(String category);

    // Wyszukaj dania poniżej określonej ceny
    List<Dishes> findByPriceLessThan(Double price);

    List<Dishes> findByPriceGreaterThan(Double price);

    List<Dishes> findByRestaurantRestaurantId(Long restaurantId);
}
