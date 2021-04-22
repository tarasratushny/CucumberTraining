package com.miamato.runner;

import com.miamato.PropertyManager;
import com.miamato.context.CucumberStepContext;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
    glue="com/miamato/stepdefinitions")
public class CucumberRunner {

    @BeforeClass
    public static void setup(){
        CucumberStepContext.getInstance().setPropertyManager(new PropertyManager("screwfix.properties"));
    }

    @AfterClass
    public static void tearDown(){
    }
}
