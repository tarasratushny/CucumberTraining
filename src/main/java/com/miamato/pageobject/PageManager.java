package com.miamato.pageobject;

import com.miamato.pageobject.screwfix.AddToBasketPopup;
import com.miamato.pageobject.screwfix.BasketPage;
import com.miamato.pageobject.screwfix.CategoriesPage;
import com.miamato.pageobject.screwfix.CookiesPopUp;
import com.miamato.pageobject.screwfix.Header;
import com.miamato.pageobject.screwfix.HomePage;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageManager {

    private static final Logger logger = LogManager.getLogger(PageManager.class.getSimpleName());

    public WebDriver driver;
    private HomePage homePage;
    private Header header;
    private CategoriesPage categoriesPage;
    private BasketPage basketPage;
    private AddToBasketPopup addToBasketPopup;
    private CookiesPopUp cookiesPopUp;

    public PageManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage homePage(){
        if(homePage == null)
            homePage = new HomePage(driver, this);
        return homePage;
    }
    public Header header(){
        if(header == null)
            header = new Header(driver, this);
        return header;
    }

    public CategoriesPage categoriesPage(){
        if(categoriesPage == null)
            categoriesPage = new CategoriesPage(driver, this);
        return categoriesPage;
    }

    public BasketPage basketPage(){
        if(basketPage == null)
            basketPage = new BasketPage(driver, this);
        return basketPage;
    }

    public AddToBasketPopup addToBasketPopup(){
        if(addToBasketPopup == null)
            addToBasketPopup = new AddToBasketPopup(driver, this);
        return addToBasketPopup;
    }

    public CookiesPopUp cookiesPopUp(){
        if(cookiesPopUp == null)
            cookiesPopUp = new CookiesPopUp(driver, this);
        return cookiesPopUp;
    }

    public PageManager open(String url){
        logger.info("Opening page with url: " + url);
        driver.navigate().to(url);
        return this;
    }

    public PageManager waitForPageToLoad(){
        logger.info("Waiting till next page is loaded");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(
            webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }
}
