package com.miamato.pageobject.screwfix;

import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {

    @FindBy(xpath = "//button[@id='topCheckoutButton']")
    WebElement continueToCheckoutTopButton;
    @FindAll(@FindBy(xpath = "//a[starts-with(@id,'trolley_page_product_name_')]"))
    List<WebElement> productForDeliveryNames;
    @FindAll(@FindBy(xpath = "//a[starts-with(@id,'CPC_trolley_page_product_name_')]"))
    List<WebElement> productForCollectionNames;
    @FindAll(@FindBy(xpath = "//a[starts-with(@id,'trolley_page_product_total_price_')]"))
    List<WebElement> productForDeliveryPrices;
    @FindAll(@FindBy(xpath = "//a[starts-with(@id,'CPC_trolley_page_product_total_price_')]"))
    List<WebElement> productForCollectionPrices;
    @FindBy(xpath = "//div[@id='trolley_page_grand_total']")
    WebElement basketGrandTotalPrice;

    public BasketPage(WebDriver driver,
        PageManager pageManager) {
        super(driver, pageManager);
    }
}
