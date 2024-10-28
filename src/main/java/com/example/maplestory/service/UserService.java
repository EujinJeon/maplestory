package com.example.maplestory.service;

import com.example.maplestory.domain.dao.UserRepository;
import com.example.maplestory.domain.dto.User;
import com.example.maplestory.domain.dto.UserID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Slf4j
@Service
@PropertySource("classpath:config.properties")
public class UserService {
    @Value("${API_KEY}")
    private String API_KEY;

    @Value("${API_URL}")
    private String API_URL;

    private final RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    public UserService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public String getUserId(String character_name) {

        Optional<User> user = userRepository.findByCharacterName(character_name);

        if (user.isPresent()) {
            return user.get().getOcid();
        }

        else {
            UserID userID = new UserID();
            String path = "maplestory/v1/id";

            URI uri = UriComponentsBuilder.fromUriString(API_URL)
                    .path(path)
                    .queryParam("character_name", character_name)
                    .encode()
                    .build()
                    .toUri();

            HttpHeaders headers = new HttpHeaders();
            headers.add("x-nxopen-api-key", API_KEY);

            HttpEntity<?> httpEntity = new HttpEntity<>(headers);
            userID = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, UserID.class).getBody();

            User new_user = new User();
            new_user.setOcid(userID.getOcid());
            new_user.setCharacterName(character_name);

            userRepository.save(new_user);

            return userID.getOcid();
        }
    }
}
