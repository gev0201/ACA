package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MercouryTourRegisterPage {

    WebDriver driver;

    @FindBy(linkText = "New Tours")
    WebElement newTours;

    @FindBy(id = "dismiss-button")
    WebElement addDismiss;

    @FindBy(linkText = "REGISTER")
    WebElement register;

    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(id = "email")
    WebElement userName;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "country")
    WebElement countrySelector;

    @FindBy(name = "confirmPassword")
    WebElement konfPassword;

    @FindBy(name = "submit")
    WebElement btnSubmit;

    @FindBy(css = "p:nth-child(1) font")
    WebElement registeredUser;


    public MercouryTourRegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickNewTours() {
        newTours.click();
    }

    public void clickDismissAdd() {
        try {
            addDismiss.click();
        } catch (Exception e) {
        }
    }

    public void clickRegister() {
        register.click();
    }

    public void inputFname(String fname) {
        firstName.sendKeys(fname);
    }

    public void inputLname(String lname) {
        lastName.sendKeys(lname);
    }

    public void inputUserName(String uName) {
        userName.sendKeys(uName);
    }

    public void inputPassword(String pass) {
        password.sendKeys(pass);
    }

    public void confirmPassword(String pass) {
        konfPassword.sendKeys(pass);
    }

    public void selectItemSelectList(String itemToSelect) {
        Select select = new Select(countrySelector);
        select.selectByValue(itemToSelect);
    }

    public void clickSubmit() {
        btnSubmit.click();
    }

    public void checkRegisteredUserName(String userName) {
        Assert.assertEquals(userName, registeredUser.getText(), "UserName not match!!!");
    }

    public void checkMercuryToursPageTitle(String title) {
        Assert.assertEquals(driver.getTitle(), title, "Title not match!!!");
    }
}
