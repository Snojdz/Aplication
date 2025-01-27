package com.pyszne.pyszne.controller;

import com.pyszne.pyszne.model.Users;
import com.pyszne.pyszne.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    // Endpoint do tworzenia nowego użytkownika
    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return usersRepository.save(user);
    }

    // Endpoint do wyszukiwania użytkownika po nazwie użytkownika
    @GetMapping("/findByUsername")
    public Optional<Users> findByUsername(@RequestParam String username) {
        return usersRepository.findByUsername(username);
    }
}
