package com.miamato.stepdefinitions;

import com.miamato.PropertyManager;
import com.miamato.drivers.DriverManager;
import com.miamato.pageobject.PageManager;
import com.miamato.valueobjects.Customer;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationSteps {

    private static final Logger logger = LogManager.getLogger("RegistrationAsserts");

    WebDriver driver;
    PageManager pageManager;
    PropertyManager propertyManager;
    Customer customer;

    @Before
    public void setup(){
        driver = DriverManager.getDriver("Chrome", "Grid");
        propertyManager = new PropertyManager("clothsStore.properties");
        pageManager = new PageManager(driver, propertyManager);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("anonymous customer is on registration page")
    public void anonymous_customer_is_on_registration_page() {
        pageManager.homePage().open()
            .homePage().clickLoginButton();
    }
    @When("registration form is filled correctly")
    public void registration_form_is_filled_correctly() {
        customer = new Customer(propertyManager, "default");
        pageManager.loginPage().enterNewCustomerEmail(customer)
            .loginPage().clickCreateAccountButton()
            .loginPage().enterPersonalInformation(customer)
            .loginPage().enterAddress(customer.address)
            .loginPage().pressCreateAccountButton();
    }

    @Then("customer is logged in")
    public void customer_is_logged_in() {
        logger.info("Checking if customer is logged in");
        Assert.assertEquals(pageManager.myAccountPage().headerMyAccountLink.getText()
            , customer.name + " " + customer.lastName);
    }
    @Then("redirected to my account page")
    public void redirected_to_my_account_page() {
        logger.info("Checking if customer is on my account page");
        Assert.assertEquals(pageManager.myAccountPage().getPageTitle(), propertyManager.getProperty("my.account.title"));
    }

}
