package com.miamato.stepdefinitions;

import com.miamato.PropertyManager;
import com.miamato.context.CucumberStepContext;
import com.miamato.pageobject.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ProductSearchSteps {

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();;

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
