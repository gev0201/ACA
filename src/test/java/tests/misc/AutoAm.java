package tests.misc;

import base.SeleniumBase;
import org.testng.annotations.Test;
import pages.GooglePage;
import pages.MercouryTourRegisterPage;
import pages.SignOnPage;

public class AutoAm extends SeleniumBase {

    GooglePage googlePage;
    AutoAm autoAm;
    private String baseUrl = "https://www.google.com/";

    @Test(priority = 1)
    public void checkMercuryToursPageTitle() {
        driver.get(baseUrl);
        googlePage = new GooglePage(driver);
        googlePage.inputSearchText();
        googlePage.clickGoogleSearchButton();


    }

}
