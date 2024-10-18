package com.example.maplestory.service;

import com.example.maplestory.domain.dto.UserOcid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:config.properties")
public class UserService {
    @Value("${API_KEY}")
    private String API_KEY;

    public UserOcid getUserId() {
        UserOcid user = new UserOcid();

        return user;
    }
}
