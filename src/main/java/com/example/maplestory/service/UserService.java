package com.example.maplestory.service;

import com.example.maplestory.domain.dto.UserOcid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
@PropertySource("classpath:config.properties")
public class UserService {
    @Value("${API_KEY}")
    private String API_KEY;

    @Value("${APIURL}")
    private String APIURL;

    private final RestTemplate restTemplate;

    public UserService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public UserOcid getUserId(String character_name) {
        UserOcid user = new UserOcid();
        String url = APIURL + "maplestory/v1/id";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("character_name", character_name);

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-nxopen-api-key", API_KEY);

        System.out.println(headers);

        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, httpEntity, UserOcid.class).getBody();
    }
}
