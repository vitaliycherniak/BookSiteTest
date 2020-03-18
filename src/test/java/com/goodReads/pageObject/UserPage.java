package com.goodReads.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    By searchBookField = By.xpath("//div[@class='searchBox searchBox--navbar']//input[@placeholder='Search books']");
    By searchQueryMainField = By.xpath("//input[@id='search_query_main']");
    By profileDropDown = By.xpath("//a[@class='dropdown__trigger dropdown__trigger--profileMenu dropdown__trigger--personalNav']");
    By logoutButton = By.xpath("//a[@class='siteHeader__subNavLink'][contains(text(),'Sign out')]");
    By skipFirstStepButton = By.xpath("//a[@class='actionLink']");
    By skipSecondStepButton = By.xpath("//span[@class='actionLink']");
    By artCheckBox = By.xpath("//div[@id='genre_Art']");
    By continueButton = By.xpath("//input[@name='commit']");
    By finishedRatingButton = By.xpath("//a[text()='I’m finished rating']");

    public UserPage clickSkipFirstStepButton() {
        driver.findElement(skipFirstStepButton).click();
        return this;
    }

    public UserPage clickSkipSecondStepButton(){
        driver.findElement(skipSecondStepButton).click();
        return this;
    }

    public UserPage selectArtCheckBox() {
        driver.findElement(artCheckBox).click();
        return this;
    }

    public UserPage clickContinueButton() {
        driver.findElement(continueButton).click();
        return this;
    }

    public UserPage clickFinishedRatingButton() {
        driver.findElement(finishedRatingButton).click();
        return this;
    }

    public UserPage checkSearchBookFieldIsPresent() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchBookField));
        return this;
    }

    public UserPage inputSearchBookField(String text) {
        driver.findElement(searchBookField).sendKeys(text);
        driver.findElement(searchBookField).sendKeys(Keys.ENTER);
        return this;
    }

    public UserPage checkSearchQueryMainFieldIsPresent() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchQueryMainField));
        return this;
    }

    public UserPage clickWantToReadButton(int numberButton) {
        String buttonXpath = "//body//tr[" + numberButton + "]//div[@class='wtrUp wtrLeft']";
        driver.findElement(By.xpath(buttonXpath)).click();
        return this;
    }

    public UserPage checkWantToReadButtonIsSelected(int numberButton) {
        String buttonXpath = "//body//tr[" + numberButton + "]//div[@class='wtrDown wtrLeft wtrShelfSortable wtrStatusToRead']";
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(buttonXpath)));
        return this;
    }

    public UserPage openBookDropDown(int numberButton) {
        String buttonXpath = "/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[" + numberButton +"]/td[2]/div[2]/div[1]/div[2]/button[1]";
        driver.findElement(By.xpath(buttonXpath)).click();
        return this;
    }
    public ReadPopUp clickReadButton(){
        driver.findElement(By.xpath("//li[1]//button[1]//span[1]")).click();
        return new ReadPopUp(driver);
    }

    public UserPage checkBookReviewReadButton(int numberButton) {
        String buttonXpath1 = "//body//tr[" + numberButton + "]//div[@class='wtrDown wtrLeft wtrStatusRead']";
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(buttonXpath1)));
        return this;
    }

    public UserPage openProfileDropDown() {
        driver.findElement(profileDropDown).click();
        return this;
    }

    public SignOutPage clickLogOutButton() {
        driver.findElement(logoutButton).click();
        return new SignOutPage(driver);
    }
}
