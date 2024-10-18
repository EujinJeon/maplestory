package com.example.maplestory.service;

import com.example.maplestory.domain.dto.UserOcid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@PropertySource("classpath:config.properties")
public class UserService {
    @Value("${API_KEY}")
    private String API_KEY;


    private final RestTemplate restTemplate;

    public UserService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public UserOcid getUserId() {
        UserOcid user = new UserOcid();

        return user;
    }
}
