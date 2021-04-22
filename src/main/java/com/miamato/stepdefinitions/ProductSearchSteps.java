package com.miamato.stepdefinitions;

import com.miamato.PropertyManager;
import com.miamato.context.CucumberStepContext;
import com.miamato.pageobject.PageManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Locale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ProductSearchSteps {

    private static final Logger logger = LogManager.getLogger(ProductSearchSteps.class.getSimpleName());

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();;

    @When("Customer performs search for {string}")
    public void customer_performs_search_for(String searchTermPropertyName) {
        pageManager.header().enterSearchTerm(propertyManager.getProperty(searchTermPropertyName))
            .header().initiateSearch();
    }


}
