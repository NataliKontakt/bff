package com.example.bff_service.controller;

import com.example.contracts.model.Order;
import com.example.contracts.model.User;
import com.example.contracts.model.UserOrderDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/site-bff")
public class BffController {

    private final RestTemplate restTemplate;

    private final String userServiceUrl = "http://localhost:8080/api/users/";
    private final String orderServiceUrl = "http://localhost:8081/api/orders/by-user/";

    public BffController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserOrderDto> getUserData(@PathVariable("userId") Long userId) {
        // Получаем пользователя
        User user = restTemplate.getForObject(userServiceUrl + userId, User.class);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        // Получаем заказы пользователя (список)
        ResponseEntity<List<Order>> response = restTemplate.exchange(
                orderServiceUrl + userId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Order>>() {}
        );
        List<Order> orders = response.getBody();

        UserOrderDto dto = new UserOrderDto(user, orders);
        return ResponseEntity.ok(dto);
    }
}
