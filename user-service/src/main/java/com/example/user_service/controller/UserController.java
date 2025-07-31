package com.example.user_service.controller;

import com.example.contracts.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Map<Long, User> USER_DATA = Map.of(
            1L, new User(1L, "Иван Иванов", "Москва, ул. Пушкина", "+79991234567", "ivan@example.com"),
            2L, new User(2L, "Мария Смирнова", "Санкт-Петербург, Невский пр.", "+79991234568", "maria@example.com")
    );

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return USER_DATA.getOrDefault(userId, null);
    }
}
