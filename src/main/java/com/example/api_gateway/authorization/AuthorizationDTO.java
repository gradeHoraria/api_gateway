package com.example.api_gateway.authorization;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationDTO {
    private String password;
    private String username;
}


