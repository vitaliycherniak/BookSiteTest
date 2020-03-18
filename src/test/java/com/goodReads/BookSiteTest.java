package com.goodReads;
import com.goodReads.pageObject.HomePage;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;


public class BookSiteTest extends WebDriverSettings {


    @Test
    public void loginWithInvalidCredentials() {

        Random random = new Random();
        int n = random.nextInt(100)+1;

        String email = "vitaliymarketolog" + n + "@gmail.com";
        String password = "3232irata" + n;
        String actualErrorMsg = "Sorry, that email or password isn't right. You can reset your password.";

        String textLoginErrorMsg = new HomePage(driver)
                .open()
                .inputEmail(email)
                .inputPassword(password)
                .clickUserLoginButton()
                .checkErrorField()
                .getTextErrorLoginMsg();
        assertEquals(textLoginErrorMsg, actualErrorMsg);

    }

    @Test
    public void fullTest(){

        Random random = new Random();
        int n = random.nextInt(100)+1;

        String email = "vitaliy" + n + "@gmail.com";
        String password = "3232irata" + n;
        String name = "vitaliy" + n;

        String text = "Best crime and mystery books";
        String headingSignOutPage = "You’ve been signed out.";

        int firstBook = 1;
        String reviewFirstBook = "review First Book";
        int rateFirstBook = 5;
        int startYearFirstBook = 2017;
        String monthFirstBook = "April";
        int dayFirstBook = 27;
        int finishYearFirstBook = 2018;

        int secondBook = 2;
        String reviewSecondBook = "review Second Book";
        int rateSecondBook = 4;
        int startYearSecondBook = 2015;
        String monthSecondBook = "March";
        int daySecondBook = 26;
        int finishYearSecondBook = 2016;

        int thirdBook = 3;
        String reviewThirdBook = "review Third Book";
        int rateThirdBook = 3;
        int startYearThirdBook = 2012;
        String monthThirdBook = "June";
        int dayThirdBook = 25;
        int finishYearThirdBook = 2013;

        String textHeaderSignOutPage = new HomePage(driver)
                .open()
                .inputUserFirstNameRegField(name)
                .inputUserEmailRegField(email)
                .inputUserPasswordRegField(password)
                .clickSignUpButton()
                .clickSkipFirstStepButton()
                .clickSkipSecondStepButton()
                .selectArtCheckBox()
                .clickContinueButton()
                .clickFinishedRatingButton()
                .checkSearchBookFieldIsPresent()

                .inputSearchBookField(text)
                .checkSearchQueryMainFieldIsPresent()
                .clickWantToReadButton(firstBook)
                .checkWantToReadButtonIsSelected(firstBook)
                .clickWantToReadButton(secondBook)
                .checkWantToReadButtonIsSelected(secondBook)
                .clickWantToReadButton(3)
                .checkWantToReadButtonIsSelected(3)

                .openBookDropDown(firstBook)
                .clickReadButton()
                .inputReview(reviewFirstBook)
                .rateBook(rateFirstBook)
                .inputStartYear(startYearFirstBook)
                .inputStartMonth(monthFirstBook)
                .inputStartDay(dayFirstBook)
                .inputFinishYear(finishYearFirstBook)
                .inputFinishMonth(monthFirstBook)
                .inputFinishDay(dayFirstBook)
                .clickReviewSubmitButton()
                .checkBookReviewReadButton(firstBook)

                .openBookDropDown(secondBook)
                .clickReadButton()
                .inputReview(reviewSecondBook)
                .rateBook(rateSecondBook)
                .inputStartYear(startYearSecondBook)
                .inputStartMonth(monthSecondBook)
                .inputStartDay(daySecondBook)
                .inputFinishYear(finishYearSecondBook)
                .inputFinishMonth(monthSecondBook)
                .inputFinishDay(daySecondBook)
                .clickReviewSubmitButton()
                .checkBookReviewReadButton(secondBook)

                .openBookDropDown(thirdBook)
                .clickReadButton()
                .inputReview(reviewThirdBook)
                .rateBook(rateThirdBook)
                .inputStartYear(startYearThirdBook)
                .inputStartMonth(monthThirdBook)
                .inputStartDay(dayThirdBook)
                .inputFinishYear(finishYearThirdBook)
                .inputFinishMonth(monthThirdBook)
                .inputFinishDay(dayThirdBook)
                .clickReviewSubmitButton()
                .checkBookReviewReadButton(thirdBook)

                .openProfileDropDown()
                .clickLogOutButton()
                .getTextHeaderSignOutPage();
        assertEquals(textHeaderSignOutPage, headingSignOutPage);

    }
}
