package com.miamato.pageobject.screwfix;

import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import io.qameta.allure.Step;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToBasketPopup extends BasePage {

    private static final Logger logger = LogManager.getLogger(AddToBasketPopup.class.getSimpleName());

    @FindBy(xpath = "//button[@id='checkout_now_btn']")
    public WebElement checkoutNowButton;
    @FindBy(xpath = "//button[@id='continue_button_btn']")
    public WebElement continueShoppingButton;


    public AddToBasketPopup(WebDriver driver,
        PageManager pageManager) {
        super(driver, pageManager);
    }

    public PageManager proceedToBasket(){
        logger.info("Proceeding to basket");
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(checkoutNowButton))
            .click();
        return pageManager;
    }

    public PageManager continueShopping(){
        logger.info("Pressing continue shopping");
        continueShoppingButton.click();
        return pageManager;
    }
}
