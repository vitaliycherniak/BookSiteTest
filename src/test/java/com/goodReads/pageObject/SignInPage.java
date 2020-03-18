package com.goodReads.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    By errorMsgLocator = By.xpath("//div[@class='gr-flashMessage gr-flashMessage--error']");

    public SignInPage checkErrorField() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errorMsgLocator));
        return this;
    }

    public String getTextErrorLoginMsg() {
        return driver.findElement(errorMsgLocator).getText();
    }
}
