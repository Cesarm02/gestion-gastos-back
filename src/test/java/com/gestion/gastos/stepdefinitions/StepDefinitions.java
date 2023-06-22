package com.gestion.gastos.stepdefinitions;

import com.gestion.gastos.consumers.ConsumerAddUser;
import com.gestion.gastos.consumers.ConsumerGetToken;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;

public class StepDefinitions {
    private ResponseEntity<String> response;
    Log LOGGER = LogFactory.getLog(StepDefinitions.class);
    private String token;



    @Dado("que Juan desea utilizar la API de usuarios")
    public void queJuanDeseaUtilizarLaApiDeUsuarios(){
        LOGGER.info("<----------- Empezando pruebas con API --------> ");
    }

    @Cuando("el quiera agregar un usuario:")
    public void elQuieraAgregarUnUsuario(DataTable users) {
        ConsumerAddUser consumerAddUser = new ConsumerAddUser();
        users.asLists().subList(1,users.asLists().size())
                .forEach(user -> {
                    try {
                        System.out.println("Resultado.. "+consumerAddUser.addUser(user).getBody());

                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                });

    }

    @Entonces("debería poder hacerlo")
    public void deberíaPoderHacerlo() {
    }

    @Cuando("el quiera consultar todos los estudiantes")
    public void elQuieraConsultarTodosLosEstudiantes() {
        
    }

    @Entonces("debería ver una lista con cada estudiante")
    public void deberíaVerUnaListaConCadaEstudiante() {
        
    }

    @Cuando("el quiera eliminar el estudiante con el id {int}")
    public void elQuieraEliminarElEstudianteConElId(int arg0) {
        
    }

    @Entonces("no deberá ver más ese estudiante al consultarlo nuevamente")
    public void noDeberáVerMásEseEstudianteAlConsultarloNuevamente() {
        
    }

    @Cuando("el quiera consultar un estudiante por id")
    public void elQuieraConsultarUnEstudiantePorId() {
        
    }

    @Entonces("deberá obtener la información de ese estudiante")
    public void deberáObtenerLaInformaciónDeEseEstudiante() {
        
    }


    @Y("se autentico correctamente")
    public void seAutenticoCorrectamente() throws URISyntaxException, JSONException {
        ConsumerGetToken getToken = new ConsumerGetToken("prueba","prueba");
        JSONObject response = new JSONObject(getToken.getToken().getBody());
        this.token = response.getString("token");
        System.out.println("token... "+this.token);
    }
}
