package com.miamato.pageobject.screwfix;

import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class CategoriesPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CategoriesPage.class.getSimpleName());

    @FindAll(@FindBy(xpath = "//a[contains(@id, 'product_description_')]"))
    public List<WebElement> productTitles;
    @FindAll(@FindBy(xpath = "//span[contains(@id, 'product_quoteNo_')]"))
    public List<WebElement> productSkus;
    @FindAll(@FindBy(xpath = "//h4[contains(@id, 'product_list_price_')]"))
    public List<WebElement> productPrices;
    @FindAll(@FindBy(xpath = "//input[contains(@id, 'product_qty_')]"))
    public List<WebElement> productQuantityFields;
    @FindAll(@FindBy(xpath = "//button[contains(@id, 'add_for_collection_button_')]"))
    public List<WebElement> addProductToClickCollectButtons;
    @FindAll(@FindBy(xpath = "//*[contains(@id, 'product_add_button_')]"))
    public List<WebElement> addProductToDeliveryButton;
    @FindBy(xpath = "//span[contains(@class, 'category-itemfound')]")
    public WebElement searchResultCount;

    public CategoriesPage(WebDriver driver,
        PageManager pageManager) {
        super(driver, pageManager);
    }
}
