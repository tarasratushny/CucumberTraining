package com.miamato.pageobject;

import com.miamato.PropertyManager;
import com.miamato.pageobject.clothstore.HomePage;
import com.miamato.pageobject.clothstore.LoginPage;
import com.miamato.pageobject.clothstore.MyAccountPage;
import com.miamato.pageobject.clothstore.MyAddressesPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public class PageManager {

    public WebDriver driver;
    public PropertyManager propertyManager;

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAddressesPage myAddressesPage;
    private MyAccountPage myAccountPage;

    public PageManager(WebDriver driver, PropertyManager propertyManager){
        this.driver = driver;
        this.propertyManager = propertyManager;
    }

    public HomePage homePage(){
        if(homePage == null)
            homePage = new HomePage(driver, propertyManager, this);
        return homePage;
    }

    public LoginPage loginPage(){
        if(loginPage == null)
            loginPage = new LoginPage(driver, propertyManager, this);
        return loginPage;
    }

    public MyAddressesPage myAddressesPage(){
        if(myAddressesPage == null)
            myAddressesPage = new MyAddressesPage(driver, propertyManager, this);
        return myAddressesPage;
    }

    public MyAccountPage myAccountPage(){
        if(myAccountPage == null)
            myAccountPage = new MyAccountPage(driver, propertyManager, this);
        return myAccountPage;
    }

}
