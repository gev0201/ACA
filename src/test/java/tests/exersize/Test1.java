package tests.exersize;

import base.SeleniumBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MercouryTourRegisterPage;
import pages.PaymentGatewayPage;
import pages.SignOnPage;
import pages.TestExPage;
import utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class Test1 extends SeleniumBase {

    TestExPage testExPage;
    String userName;
    String userEmail;
    Map<String, String> accInfo;
    Map<String, String> address;
    Utils utils = new Utils();

    @BeforeTest
    public void initCredentials(){
        userName = utils.generateRandomString(5);
        userEmail = userName +  "@mail.com";
        accInfo = new HashMap<>();
        address = new HashMap<>();
        accInfo.put("gender", "male");
        accInfo.put("password", "123456");
        accInfo.put("day", "1");
        accInfo.put("month", "June");
        accInfo.put("year", "2000");
        accInfo.put("news", "true");
        accInfo.put("offer", "true");
        address.put("fname", "Gevorg");
        address.put("lname", "Gevorg");
        address.put("company", "HS");
        address.put("address1", "Bgh");
        address.put("address2", "");
        address.put("country", "Canada");
        address.put("state", "asde");
        address.put("city", "Ontario");
        address.put("zipcode", "11111");
        address.put("mobilenum", "4564877987987");

    }

    @Test(priority = 1)
    public void registerUsere() throws InterruptedException {
        driver.get("http://automationexercise.com");
        testExPage = new TestExPage(driver);
        testExPage.isHomePageLoad();
        testExPage.goToSignup();
        testExPage.register(userName, userEmail);
        testExPage.enterAccInfo(accInfo);
        testExPage.enteraddress(address);
        testExPage.deleteAcc(userName);

    }
}
