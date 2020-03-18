package com.goodReads.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReadPopUp {

    WebDriver driver;

    public ReadPopUp (WebDriver driver) {
        this.driver = driver;
    }

    By reviewBookField = By.xpath("//textarea[@id='review_review_usertext']");
    By startYearField = By.xpath("//div[@class='readingSessionDatePicker smallPicker startedAtYear']");
    By startMothField = By.xpath("//div[@class='largePicker readingSessionDatePicker startedAtMonth']");
    By startDayField = By.xpath("//div[@class='readingSessionDatePicker smallPicker startedAtDay']");
    By finishYearField = By.xpath("//span[@class='endedAtYear readingSessionDatePicker smallPicker']");
    By finishMonthField = By.xpath("//span[@class='endedAtMonth largePicker readingSessionDatePicker']");
    By finishDayField = By.xpath("//span[@class='endedAtDay readingSessionDatePicker smallPicker']");
    By reviewSubmitButton = By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/form[1]/div[1]/div[14]/input[1]");

    public ReadPopUp inputReview(String text) {
        driver.findElement(reviewBookField).sendKeys(text);
        return this;
    }

    public ReadPopUp rateBook(int rate) {
        String rateXpath = "//div[@class='formItem']//a[@class='star off'][contains(text(),'" + rate +" of 5 stars')]";
        driver.findElement(By.xpath(rateXpath)).click();
        return this;
    }

    public ReadPopUp inputStartYear(int year) {
        driver.findElement(startYearField).click();
        String yearXpath = "//div[@class='readingSessionDatePicker smallPicker startedAtYear']//select//option[text()='" + year + "']";
        driver.findElement(By.xpath(yearXpath)).click();
        return this;
    }

    public ReadPopUp inputStartMonth(String month) {
        driver.findElement(startMothField).click();
        String monthXpath = "//div[@class='largePicker readingSessionDatePicker startedAtMonth']//select//option[text()='" + month + "']";
        driver.findElement(By.xpath(monthXpath)).click();
        return this;
    }

    public ReadPopUp inputStartDay(int day) {
        driver.findElement(startDayField).click();
        String dayXpath = "//div[@class='readingSessionDatePicker smallPicker startedAtDay']//select//option[text()='" + day + "']";
        driver.findElement(By.xpath(dayXpath)).click();
        return this;
    }

    public ReadPopUp inputFinishYear(int year) {
        driver.findElement(finishYearField).click();
        String yearXpath = "//span[@class='endedAtYear readingSessionDatePicker smallPicker']//select//option[text()='" + year + "']";
        driver.findElement(By.xpath(yearXpath)).click();
        return this;
    }

    public ReadPopUp inputFinishMonth(String month) {
        driver.findElement(finishMonthField).click();
        String monthXpath = "//span[@class='endedAtMonth largePicker readingSessionDatePicker']//select//option[text()='" + month + "']";
        driver.findElement(By.xpath(monthXpath)).click();
        return this;
    }

    public ReadPopUp inputFinishDay(int day) {
        driver.findElement(finishDayField).click();
        String dayXpath = "//span[@class='endedAtDay readingSessionDatePicker smallPicker']//select//option[text()='" + day + "']";
        driver.findElement(By.xpath(dayXpath)).click();
        return this;
    }

    public UserPage clickReviewSubmitButton() {
        driver.findElement(reviewSubmitButton).click();
        return new UserPage(driver);
    }
}


