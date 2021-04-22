package com.miamato.stepdefinitions;

import com.miamato.PropertyManager;
import com.miamato.context.CucumberStepContext;
import com.miamato.drivers.DriverManager;
import com.miamato.pageobject.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SetupSteps {

    @Before
    public void setup(){
        CucumberStepContext context = CucumberStepContext.getInstance();
        context.setPropertyManager(new PropertyManager("screwfix.properties"));
        context.setDriver(DriverManager.getDriver("Chrome", "GRID"));
        context.setPageManager( new PageManager(context.getDriver()));
    }

    @After
    public void tearDown(){
        CucumberStepContext.getInstance().getDriver().quit();
    }

}
