package tests.seleniumTests;

import base.SeleniumBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MercouryTourRegisterPage;
import pages.SignOnPage;


public class TestRegisterUser extends SeleniumBase {

    MercouryTourRegisterPage mercouryTourRegisterPage;
    SignOnPage signOnPage;

    @Test(priority = 1)
    public void checkMercuryToursPageTitle() {
        mercouryTourRegisterPage = new MercouryTourRegisterPage(driver);
        mercouryTourRegisterPage.clickNewTours();
        mercouryTourRegisterPage.clickDismissAdd();
        mercouryTourRegisterPage.checkMercuryToursPageTitle("Welcome: Mercury Tours");
    }

    @Test(priority = 2)
    public void registerNewUser() {
        mercouryTourRegisterPage = new MercouryTourRegisterPage(driver);
        mercouryTourRegisterPage.clickRegister();
        mercouryTourRegisterPage.inputFname("Gevorg");
        mercouryTourRegisterPage.inputLname("Gevorgyan");
        mercouryTourRegisterPage.selectItemSelectList("ARMENIA");
        mercouryTourRegisterPage.inputUserName("gg@mail.com");
        mercouryTourRegisterPage.inputPassword("Pass123456");
        mercouryTourRegisterPage.confirmPassword("Pass123456");
        mercouryTourRegisterPage.clickSubmit();
        mercouryTourRegisterPage.checkRegisteredUserName("Dear Gevorg Gevorgyan,");
    }

    @Test(priority = 3)
    public void loginMercouryTours() {
        mercouryTourRegisterPage = new MercouryTourRegisterPage(driver);
        SignOnPage signOnPage = new SignOnPage(driver);
        signOnPage.clickSignOn();
        signOnPage.inputUserrname("gg@mail.com");
        mercouryTourRegisterPage.inputPassword("Pass123456");
        mercouryTourRegisterPage.clickSubmit();
        Assert.assertTrue(signOnPage.checkMessage().equals("Login Successfully"), "Message Not match!!!");


    }

}

