package com.miamato.pageobject.screwfix;

import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

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
}
