package com.gestion.gastos.consumers;

import com.gestion.gastos.constantes.Constantes;
import com.gestion.gastos.dto.RequestCreateUser;
import com.gestion.gastos.dto.RequestToken;
import com.gestion.gastos.dto.ResponseCreateUser;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class ConsumerAddUser {

    private RestTemplate restTemplate = new RestTemplate();


    public ResponseEntity<ResponseCreateUser> addUser(List<String> user) throws URISyntaxException {
        HttpHeaders headers =new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RequestCreateUser> request = new HttpEntity<>(RequestCreateUser.builder().nombre(user.get(0))
                .apellido(user.get(1)).email(user.get(2)).telefono(Integer.parseInt(user.get(3)))
                .edad(Integer.parseInt(user.get(4))).username(user.get(5)).password(user.get(6)).build()
                ,headers);
        return restTemplate.postForEntity(new URI(Constantes.PATH_URL+ Constantes.END_POINT),request,ResponseCreateUser.class);
    }
}
