package com.miamato.stepdefinitions;

import com.miamato.PropertyManager;
import com.miamato.context.CucumberStepContext;
import com.miamato.pageobject.PageManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BasketSteps {
    private static final Logger logger = LogManager.getLogger(BasketSteps.class.getSimpleName());

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();;

    @Then("Products should be present on basket page")
    public void productsShoudlBePresentOnBasketPage(DataTable dataTable){
        List<Map<String,String>> rows = dataTable.asMaps(String.class, String.class);
        int i = 0;
        for(Map<String, String> column : rows){
            checkProductInBasket(propertyManager.getProperty(column.get("product name")), i);
            i++;
        }
    }

    private void checkProductInBasket(String productName, int position){
        logger.info("Checking product name");
        Assert.assertEquals(productName, pageManager.basketPage().productForDeliveryNames.get(position).getText());

    }

}
