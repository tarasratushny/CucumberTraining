package com.miamato.stepdefinitions;

import com.miamato.PropertyManager;
import com.miamato.context.CucumberStepContext;
import com.miamato.pageobject.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class NavigationSteps {

    private static final Logger logger = LogManager.getLogger(NavigationSteps.class.getSimpleName());

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();


    @Given("Customer is on page with url {string}")
    public void customerIsOnPageWithUrlHomePageUrl(String pageName) {
        pageManager.open(propertyManager.getProperty(pageName))
            .waitForPageToLoad()
            .cookiesPopUp().acceptAllCookies()
            .waitForPageToLoad();
    }

    @Then("Page title contains {string}")
    public void pageTitleContainsDirectProductName(String productName) {
        logger.info("Checking if product name is correct in product details page title");
        Assert.assertTrue(driver.getTitle().trim().contains(propertyManager.getProperty(productName)));
    }

}
