package com.example.maplestory.service;

import com.example.maplestory.domain.dto.UserOcid;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void getUserIdTest() {
        UserOcid user = new UserOcid();
        String character_name = "금쪽이핸들러";
        user = userService.getUserId(character_name);
        System.out.println(user.getOcid());
    }
}
