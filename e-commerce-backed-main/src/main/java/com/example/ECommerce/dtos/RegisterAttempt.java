package com.example.ECommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAttempt {
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
