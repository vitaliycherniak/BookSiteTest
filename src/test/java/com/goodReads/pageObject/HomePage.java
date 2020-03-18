package com.goodReads.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    By userSignInFormEmail_field = By.xpath("//input[@id='userSignInFormEmail']");
    By userPassword_field = By.xpath("//input[@id='user_password']");
    By userLogin_button = By.xpath("//input[@class='gr-button gr-button--dark']");
    By userFirstNameRegField = By.xpath("//input[@id='user_first_name']");
    By userEmailRegField = By.xpath("//input[@id='user_email']");
    By userPasswordRegField = By.xpath("//input[@id='user_password_signup']");
    By signUpButton = By.xpath("//input[@name='next']");

    public UserPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new UserPage(driver);
    }

    public HomePage inputUserFirstNameRegField(String name) {
        driver.findElement(userFirstNameRegField).sendKeys(name);
        return this;
    }

    public HomePage inputUserEmailRegField(String email) {
        driver.findElement(userEmailRegField).sendKeys(email);
        return this;
    }

    public HomePage inputUserPasswordRegField(String password) {
        driver.findElement(userPasswordRegField).sendKeys(password);
        return this;
    }

    public HomePage open() {
        driver.get("https://www.goodreads.com/");
        return this;
    }

    public HomePage inputEmail(String email) {
        driver.findElement(userSignInFormEmail_field).sendKeys(email);
        return this;
    }

    public HomePage inputPassword(String password) {
        driver.findElement(userPassword_field).sendKeys(password);
        return this;

    }

    public SignInPage clickUserLoginButton() {
        driver.findElement(userLogin_button).click();
        return new SignInPage(driver);
    }

    public UserPage clickUserLoginButtonWithValidCredentials() {
        driver.findElement(userLogin_button).click();
        return new UserPage(driver);
    }
}
