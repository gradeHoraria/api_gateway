package com.example.api_gateway.authorization;

import lombok.Getter;

@Getter
public class AuthorizationConfig {
    private String serverUrlToken = "http://keycloak:8080/realms/gradeHoraria/protocol/openid-connect/token";
    private String clientId = "api_teachers";
    private String grantType = "password";
}
