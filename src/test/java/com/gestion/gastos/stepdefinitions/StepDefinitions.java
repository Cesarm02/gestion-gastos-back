package com.gestion.gastos.stepdefinitions;

import com.gestion.gastos.configuraciones.ConsumerServices;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.ResponseEntity;

public class StepDefinitions {
    private ResponseEntity<String> response;
    Log LOGGER = LogFactory.getLog(StepDefinitions.class);
    private ConsumerServices studentImp;

    @Dado("que Juan desea utilizar la API de usuarios")
    public void queJuanDeseaUtilizarLaApiDeUsuarios(){
        LOGGER.info("<----------- Empezando pruebas con API --------> ");
    }

    @Cuando("el quiera agregar un usuario:")
    public void elQuieraAgregarUnUsuario(DataTable users) {
        Assertions.assertNull(users);
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

    @Dado("que Juan necesita obtener un token para autenticarse de forma exitosa")
    public void queJuanNecesitaObtenerUnTokenParaAutenticarseDeFormaExitosa() {
        
    }

    @Entonces("deberá consumir obtener un token de forma correcta")
    public void deberáConsumirObtenerUnTokenDeFormaCorrecta() {
    }
}
