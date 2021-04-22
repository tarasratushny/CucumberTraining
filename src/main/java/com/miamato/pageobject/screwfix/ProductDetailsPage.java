package com.miamato.pageobject.screwfix;

import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(ProductDetailsPage.class.getSimpleName());

    @FindBy(xpath = "//h1[@id='product_description']/span[@itemprop='name']")
    public WebElement productName;
    @FindBy(xpath = "//span[@itemprop='productID']")
    public WebElement productSku;
    @FindBy(xpath = "//button[@id='product_add_to_trolley_image']")
    public WebElement addToDeliveryButton;
    @FindBy(xpath = "//button[contains(@id,'add_for_collection_button_')]")
    public WebElement addToCollectionButton;

    public ProductDetailsPage(WebDriver driver,
        PageManager pageManager) {
        super(driver, pageManager);
    }

    public PageManager addProductToHomeDelivery(){
        logger.info("Clicking 'Home Delivery' button");
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(addToDeliveryButton))
            .click();
        return pageManager;
    }

    public PageManager addProductToClickCollect(){
        logger.info("Clicking 'Click Collect' button");
        addToCollectionButton.click();
        return pageManager;
    }
}
