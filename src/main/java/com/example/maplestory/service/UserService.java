package com.example.maplestory.service;

import com.example.maplestory.domain.dao.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:config.properties")
public class UserService {
    @Value("${API_KEY}")
    private String api_key;

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String userOcid(String characName){
        String user_id = userRepository.getOcid(api_key, characName);
        return user_id;
    }
}
