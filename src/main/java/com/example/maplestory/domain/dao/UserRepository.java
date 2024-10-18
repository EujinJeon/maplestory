package com.example.maplestory.domain.dao;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;

@Repository
@NoArgsConstructor
public class UserRepository {

    private final String apiUrl = "https://open.api.nexon.com";

    public String getOcid(String api_key, String characterName){
        try {
            // Url Setting
            String charName = URLEncoder.encode(characterName, StandardCharsets.UTF_8);
            String requesUrl = apiUrl + "/maplestory/v1/id?character_name=" + characterName;
            URL url = (new URI(requesUrl)).toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("x-nxopen-api-key", api_key);

            int responseCode = connection.getResponseCode();

            BufferedReader in;
            if(responseCode == 200) {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();

        }
        catch (Exception e){
            return ("Failed : " + e.getMessage());
        }

    }
}
