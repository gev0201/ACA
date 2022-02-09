package tests.seleniumTests;

import base.SeleniumBase;
import org.testng.annotations.Test;
import pages.MercouryTourRegisterPage;
import pages.MercouryToursFlightPage;
import pages.SignOnPage;

public class TestSearchFlight extends SeleniumBase {

    MercouryTourRegisterPage mercouryTourRegisterPage;
    SignOnPage signOnPage;
    MercouryToursFlightPage mercouryToursFlightPage;

    @Test(priority = 1)
    public void checkMercuryToursFlightRegister() {
        mercouryTourRegisterPage = new MercouryTourRegisterPage(driver);
        signOnPage = new SignOnPage(driver);
        mercouryToursFlightPage = new MercouryToursFlightPage(driver);

        mercouryTourRegisterPage.clickNewTours();
        mercouryToursFlightPage.clickFlights();
    }

}
