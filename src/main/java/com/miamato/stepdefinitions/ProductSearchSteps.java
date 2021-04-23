package com.miamato.stepdefinitions;

import com.miamato.properties.PropertyManager;
import com.miamato.context.CucumberStepContext;
import com.miamato.pageobject.PageManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ProductSearchSteps {

    private static final Logger logger = LogManager.getLogger(ProductSearchSteps.class.getSimpleName());

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();

    @When("Customer performs search for {string}")
    public void customer_performs_search_for(String searchTermPropertyName) {
        pageManager.header().enterSearchTerm(propertyManager.getProperty(searchTermPropertyName))
            .header().initiateSearch();
    }


    @Then("Search result count is more than {int}")
    public void searchResultCountIsMoreThanSearchResultCount(int minSearchResultsCount) {
        logger.info("Checking that search results count is more than " + minSearchResultsCount);
        Assert.assertTrue(Integer.parseInt(pageManager.categoriesPage().searchResultCount.getAttribute("found"))
            > minSearchResultsCount);
    }

    @When("Customer adds multiple products from search")
    public void customerAddsMultipleProductsFromSearch(DataTable dataTable) {
        List<Map<String,String>> rows = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> column : rows){
            logger.info("searching for " + propertyManager.getProperty(column.get("direct hit search term")));
           pageManager.header().enterSearchTerm(
               propertyManager.getProperty(column.get("direct hit search term")))
               .header().initiateSearch();
           addProductToBasket(propertyManager.getProperty(column.get("shipping method")));
        }
    }

    private void addProductToBasket(String shippingMethod){
        if(shippingMethod.equals(propertyManager.getProperty("shipping.method.home.delivery"))) {
            pageManager.productDetailsPage().addProductToHomeDelivery()
                .addToBasketPopup().proceedToBasket();
        } else if (shippingMethod.equals(propertyManager.getProperty("shipping.method.click.collect"))){
            pageManager.productDetailsPage().addToCollectionButton.click();
        }
    }
}
