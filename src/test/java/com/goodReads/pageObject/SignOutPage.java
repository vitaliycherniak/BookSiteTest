package com.goodReads.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignOutPage {

    WebDriver driver;

    public SignOutPage (WebDriver driver) {
        this.driver = driver;
    }

    By headerSignOutPage = By.xpath("//p[@id='signed_out']");

    public String getTextHeaderSignOutPage(){
        return driver.findElement(headerSignOutPage).getText();
    }
}
