package tests.seleniumTests;

import base.SeleniumBase;
import org.testng.annotations.Test;
import pages.MercouryTourRegisterPage;
import pages.PaymentGatewayPage;
import pages.SignOnPage;

import java.util.HashMap;
import java.util.Map;

public class TestMercouriPayment extends SeleniumBase {

    MercouryTourRegisterPage mercouryTourRegisterPage;
    PaymentGatewayPage paymentGatewayPage;
    SignOnPage signOnPage;

    @Test(priority = 1)
    public void checkMercuryToursPageTitle() throws InterruptedException {
        Map<String, String> cardData = new HashMap<>();

        mercouryTourRegisterPage = new MercouryTourRegisterPage(driver);
        paymentGatewayPage = new PaymentGatewayPage(driver);
        paymentGatewayPage.clickPaymentGtwProject();
        paymentGatewayPage.clickGenerateCardPage();
        cardData.put("Number", paymentGatewayPage.getCardNumber());
        cardData.put("CVV", paymentGatewayPage.getCardCvv());
        cardData.put("expDate", paymentGatewayPage.getCardExpDate());
        paymentGatewayPage.GoToCardPage();
        paymentGatewayPage.selectQuantity("4");
        paymentGatewayPage.buyNow();
        paymentGatewayPage.inputCardNumber(cardData.get("Number"));
        paymentGatewayPage.selectExpirationMonthandYear(cardData);
        paymentGatewayPage.inputCardCvv(cardData.get("CVV"));
        paymentGatewayPage.pay();
        paymentGatewayPage.validatePayment();
    }
}
