package com.example.api_gateway.authorization;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthorizationService {
    
    public ResponseEntity<String> execute(AuthorizationDTO authorizationDTO) {

        AuthorizationConfig authorizationConfig = new AuthorizationConfig();
        String url = authorizationConfig.getServerUrlToken();

        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();

        formData.add("username", authorizationDTO.getUsername());
        formData.add("password", authorizationDTO.getPassword());
        formData.add("client_id", authorizationConfig.getClientId());
        formData.add("grant_type", authorizationConfig.getGrantType());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);

        var result = restTemplate.postForEntity(url, request, String.class);
        return result;
    }
}