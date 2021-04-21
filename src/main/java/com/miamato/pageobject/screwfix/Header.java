package com.miamato.pageobject.screwfix;

import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {

    private static final Logger logger = LogManager.getLogger(Header.class.getSimpleName());

    @FindBy(xpath = "//input[@id='mainSearch-input']")
    WebElement searchField;
    @FindBy(xpath = "//input[@id='search_submit_button']")
    WebElement searchButton;
    @FindBy(xpath = "//i[@class='icon icon-basket']")
    WebElement basketButton;
    @FindAll(@FindBy(xpath = "//ul[@class='mn']/li"))
    WebElement categoriesTopLevel;

    public Header(WebDriver driver,
        PageManager pageManager) {
        super(driver, pageManager);
    }

    public PageManager enterSearchTerm(String searchTerm){
        logger.info("Enterting search term: " + searchTerm);
        searchField.sendKeys(searchTerm);
        return pageManager;
    }

    public PageManager initiateSearch(){
        logger.info("Initiating search");
        searchButton.click();
        return pageManager;
    }

}
