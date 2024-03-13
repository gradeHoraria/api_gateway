package com.example.api_gateway.authorization;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/authorization")
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @PostMapping("/token")
    public ResponseEntity<String> login(@RequestBody AuthorizationDTO authorizationDTO) {
        return authorizationService.execute(authorizationDTO);
    }
}
