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

public class CookiesPopUp extends BasePage {

    private static final Logger logger = LogManager.getLogger(CookiesPopUp.class.getSimpleName());

    @FindBy(xpath = "//div[@class='truste_box_overlay']//iframe")
    public WebElement cookiesOverlayFrame;
    @FindBy(xpath = "//a[text()='Accept Cookies']")
    public WebElement acceptAllCookiesButton;

    public CookiesPopUp(WebDriver driver,
        PageManager pageManager) {
        super(driver, pageManager);
    }

    public PageManager acceptAllCookies(){
        logger.info("Accepting all cookies");
        driver.switchTo().frame(cookiesOverlayFrame);
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.elementToBeClickable(acceptAllCookiesButton))
            .click();
        driver.switchTo().defaultContent();
        return pageManager;
    }

}
