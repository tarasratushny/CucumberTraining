package com.miamato.stepdefinitions;

import com.miamato.context.CucumberStepContext;
import com.miamato.drivers.DriverManager;
import com.miamato.pageobject.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup(){
        CucumberStepContext.getInstance().setDriver(DriverManager.getDriver("Chrome", "GRID"));
        CucumberStepContext.getInstance().setPageManager( new PageManager(CucumberStepContext.getInstance().getDriver()));
    }

    @After
    public void cleanUp(){
        CucumberStepContext.getInstance().getDriver().quit();
    }

}
