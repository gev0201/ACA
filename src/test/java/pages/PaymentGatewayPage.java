package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Map;

public class PaymentGatewayPage {

    WebDriver driver;
    @FindBy(linkText = "Payment Gateway Project")
    WebElement paymentGtw;
    @FindBy(linkText = "Generate Card Number")
    WebElement generateCardPage;
    @FindBy(xpath = "//*[contains(text(),'Card Number:-')]")
    WebElement cardNumber;
    @FindBy(xpath = "//*[contains(text(),'CVV:-')]")
    WebElement cardCvv;
    @FindBy(xpath = "//*[contains(text(),'Exp:-')]")
    WebElement cardExpDate;
    @FindBy(linkText = "Cart")
    WebElement cartPage;
    @FindBy(name = "quantity")
    WebElement quantity;
    @FindBy(css = "[value='Buy Now']")
    WebElement buyNow;
    @FindBy(name = "card_nmuber")
    WebElement cardNumberInput;
    @FindBy(name = "month")
    WebElement expirationMonth;
    @FindBy(name = "year")
    WebElement expirationYear;
    @FindBy(name = "cvv_code")
    WebElement cvv;
    @FindBy(name = "submit")
    WebElement pay;
    @FindBy(tagName = "h2")
    WebElement successMessage;
    @FindBy(css = "td:nth-child(2) strong")
    WebElement orderId;

    public PaymentGatewayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validatePayment() throws InterruptedException {
        Assert.assertEquals(this.successMessage.getText(), "Payment successfull!", "Payment is not Success!!!");
        Assert.assertNotNull(this.orderId.getText(), "Order Id is NULL");
    }

    public void pay() {
        this.pay.click();
    }

    public void buyNow() {
        this.buyNow.click();
    }

    public void selectQuantity(String quant) {
        Select qty = new Select(quantity);
        qty.selectByValue(quant);
    }

    public void inputCardNumber(String value) {
        cardNumberInput.sendKeys(value);
    }

    public void inputCardCvv(String value) {
        cvv.sendKeys(value);
    }

    public void GoToCardPage() {
        this.cartPage.click();
    }

    public void clickPaymentGtwProject() {
        this.paymentGtw.click();
    }

    public void clickGenerateCardPage() {
        this.generateCardPage.click();
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));
    }

    public String getCardNumber() {
        String crdNum = this.cardNumber.getText();
        return crdNum.split("- ", 50)[1];
    }

    public String getCardCvv() {
        String crdcvv = this.cardCvv.getText();
        return crdcvv.split("- ", 50)[1];
    }

    public String getCardExpDate() {
        String crdExpDate = this.cardExpDate.getText();
        return crdExpDate.split("- ", 50)[1];

    }

    public void selectExpirationMonthandYear(Map cardData) {
        Select selectm = new Select(expirationMonth);
        Select selecty = new Select(expirationYear);
        String crdd = (String) cardData.get("expDate");
        String[] dayMonth = crdd.split("/");
        selectm.selectByVisibleText(dayMonth[0]);
        selecty.selectByVisibleText(dayMonth[1]);
    }
}
