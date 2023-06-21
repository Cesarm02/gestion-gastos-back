package com.gestion.gastos.configuraciones;

import com.gestion.gastos.dto.RequestCreateUser;
import com.gestion.gastos.dto.ResponseCreateUser;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ConsumerServices {
    private RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<JSONObject> getToken(){
        return null;
    }
    public ResponseEntity<ResponseCreateUser> addUser(RequestCreateUser user){
        return null;
    }
}
