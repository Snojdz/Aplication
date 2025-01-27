package com.pyszne.pyszne.repository;

import com.pyszne.pyszne.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    // Wyszukaj użytkownika po nazwie użytkownika
    Optional<Users> findByUsername(String username);

    // Wyszukaj użytkownika po adresie e-mail
    Optional<Users> findByEmail(String email);


}
