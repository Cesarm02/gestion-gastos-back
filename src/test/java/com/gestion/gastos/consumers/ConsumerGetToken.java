package com.gestion.gastos.consumers;

import com.gestion.gastos.constantes.Constantes;
import com.gestion.gastos.dto.RequestToken;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class ConsumerGetToken {
    private RestTemplate restTemplate = new RestTemplate();
    private String user;
    private String password;
    private HttpHeaders headers;

    public ConsumerGetToken(String user, String password){
        this.user= user;
        this.password = password;
        this.headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

    }
    public ResponseEntity<String> getToken() throws URISyntaxException {
        HttpEntity<RequestToken> request = new HttpEntity<>(RequestToken.builder().username(this.user)
                .password(this.password).build(),headers);
        return restTemplate.postForEntity(new URI(Constantes.PATH_URL+Constantes.END_POINT_TOKEN),request,String.class);
    }
}
