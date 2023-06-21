package com.gestion.gastos.configuraciones;

import com.gestion.gastos.GestionGastosBackApplication;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = GestionGastosBackApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class CucumberIntegration {
    Log LOGGER = LogFactory.getLog(CucumberIntegration.class);
    @Before
    public void setUp() {
        LOGGER.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
    }
}
