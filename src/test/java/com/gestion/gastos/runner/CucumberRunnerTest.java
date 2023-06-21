package com.gestion.gastos.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        publish = false,
        plugin = { "me.jvt.cucumber.report.PrettyReports:target/cucumber" },
        glue={"com.gestion.gastos.stepdefinitions","com.gestion.gastos.configuraciones"},
        tags = "@POST")
public class CucumberRunnerTest {
}
