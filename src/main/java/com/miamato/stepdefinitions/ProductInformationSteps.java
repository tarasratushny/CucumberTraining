package com.miamato.stepdefinitions;

import com.miamato.PropertyManager;
import com.miamato.context.CucumberStepContext;
import com.miamato.pageobject.PageManager;
import io.cucumber.java.en.Then;
import java.util.Locale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ProductInformationSteps {

    private static final Logger logger = LogManager.getLogger(ProductInformationSteps.class.getSimpleName());

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();

    @Then("Product name on product page contains {string}")
    public void productNameOnProductPageContainsDirectHitProductName(String propertyForProductName) {
        logger.info("Checking if product name is correct on product details page");
        Assert.assertEquals(propertyManager.getProperty(propertyForProductName).toUpperCase(Locale.ROOT),
            pageManager.productDetailsPage().productName.getText().trim());
    }


    @Then("Sku on product page is {string}")
    public void skuOnProductPageIsDirectHitProductSku(String propertyForSku) {
        logger.info("Checking if product sku is correct on product details page");
        Assert.assertEquals(propertyManager.getProperty(propertyForSku).toUpperCase(Locale.ROOT),
            pageManager.productDetailsPage().productSku.getText());
    }
}
