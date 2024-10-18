package com.example.maplestory.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

@SpringBootTest
@AutoConfigureMockMvc
@PropertySource("classpath:config.properties")
public class UserRepositoryTest {

    @Value("${API_KEY}")
    private String api_key;


    @Test
    public void userOcidTest() {
        String characterName = "금쪽이핸들러";

    }
}
