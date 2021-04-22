package com.miamato.stepdefinitions;

import com.miamato.PropertyManager;
import com.miamato.drivers.DriverManager;
import com.miamato.pageobject.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ProductSearchSteps {

    WebDriver driver;
    PageManager pageManager;
    PropertyManager propertyManager;
    @Before
    public void setup(){
        System.out.println(System.getProperty("os.name"));
        propertyManager = new PropertyManager("screwfix.properties");
        System.out.println(System.getProperty("os.name"));
        driver = DriverManager.getDriver("Chrome", "GRID");
        pageManager = new PageManager(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("Customer is on page with url {string}")
    public void customerIsOnPageWithUrlHomePageUrl(String pageName) {
        pageManager.open(propertyManager.getProperty(pageName))
            .waitForPageToLoad()
            .cookiesPopUp().acceptAllCookies();
    }

    @When("Customer performs search for {string}")
    public void customer_performs_search_for(String searchTerm) {
        pageManager.header().enterSearchTerm(searchTerm)
            .header().initiateSearch()
            .waitForPageToLoad();
    }
    @Then("Customer is redirected to {string}")
    public void customer_is_redirected_to(String string) {
        System.out.println("Some check");
    }
    @Then("Page title contains {string}")
    public void page_title_contains(String string) {
        System.out.println("Other check");
    }


}
