package com.example.maplestory.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void getUserIdTest() {
        String character_name = "삼한제일검사";
        System.out.println(userService.getUserId(character_name));
    }
}
