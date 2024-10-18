package com.example.maplestory;

import com.example.maplestory.controller.ApiController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaplestoryApplication {

    public static void main(String[] args) {

        SpringApplication.run(MaplestoryApplication.class, args);
        ApiController apiController = new ApiController();
    }

}
