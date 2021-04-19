package com.miamato.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
    glue="com/miamato/stepdefinitions")
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
