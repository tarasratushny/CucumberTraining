package com.miamato.pageobject.screwfix;

import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToBasketPopup extends BasePage {

    private static final Logger logger = LogManager.getLogger(AddToBasketPopup.class.getSimpleName());

    @FindBy(xpath = "//button[@id='checkout_now_btn']")
    WebElement checkoutNowButton;
    @FindBy(xpath = "//button[@id='continue_button_btn']")
    WebElement continueShoppingButton;


    public AddToBasketPopup(WebDriver driver,
        PageManager pageManager) {
        super(driver, pageManager);
    }
}
