package com.example.contracts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Long id;
    private String fullName;
    private String address;
    private String phone;
    private String email;
}