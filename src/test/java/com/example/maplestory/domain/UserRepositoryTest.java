package com.example.maplestory.domain;

import com.example.maplestory.domain.dao.UserRepository;
import com.example.maplestory.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private final UserService userService;

    public UserRepositoryTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    void getOcidTest() {
        String characterName = "금쪽이핸들러";
        System.out.println(userService.userOcid(characterName));
    }
}
