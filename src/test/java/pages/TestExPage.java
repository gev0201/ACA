package pages;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

import org.openqa.selenium.support.ui.Select;
import utils.Utils;

import java.util.List;
import java.util.Map;

public class TestExPage {

    WebDriver driver;
    Utils utils = new Utils();

    public TestExPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".nav.navbar-nav")
    WebElement navigationBar;

    @FindBy(css = ".nav.navbar-nav li")
    List<WebElement> navigationBarElems;


    @FindBy(linkText = "Signup / Login")
    WebElement signUpLogin;

    @FindBy(css = "[data-qa = 'signup-name']")
    WebElement nameField;

    @FindBy(css = "[data-qa = 'signup-email']")
    WebElement emailField;

    @FindBy(css = "[data-qa = 'signup-button']")
    WebElement signupButton;

    @FindBy(css = "[data-qa='name']")
    WebElement name;

    @FindBy(css = "[id='uniform-id_gender1']")
    WebElement male;

    @FindBy(css = "[id='uniform-id_gender2']")
    WebElement female;

    @FindBy(css = "[data-qa='password']")
    WebElement pass;

    @FindBy(css = "[data-qa='days']")
    WebElement day;

    @FindBy(css = "[data-qa='months']")
    WebElement month;

    @FindBy(css = "[data-qa='years']")
    WebElement year;

    @FindBy(id = "newsletter")
    WebElement news;

    @FindBy(id = "optin")
    WebElement offer;

    @FindBy(css = "[data-qa='first_name']")
    WebElement firstNameField;

    @FindBy(css = "[data-qa='last_name']")
    WebElement lastNameField;

    @FindBy(css = "[data-qa='company']")
    WebElement company;

    @FindBy(css = "[data-qa='address']")
    WebElement address1;

    @FindBy(css = "[data-qa='address2']")
    WebElement address2;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "zipcode")
    WebElement zipcode;

    @FindBy(id = "mobile_number")
    WebElement mobileNum;

    @FindBy(css = "[data-qa='create-account']")
    WebElement createAcc;

    @FindBy(css = ".title.text-center")
    WebElement accInfoText;

    @FindBy(css = "[data-qa='account-created']")
    WebElement accCreated;

    @FindBy(css = "[data-qa='continue-button']")
    WebElement continueBtn;

    @FindBy(linkText = "Delete Account")
    WebElement delAcc;

    @FindBy(css = ".page-header")
    WebElement delSuccess;





    public void isHomePageLoad(){
        if (navigationBar != null && driver.getTitle().equals("Automation Exercise")){
           assertTrue(true, "Home page loaded");
        } else {
            assertTrue(false, "Home page not loaded");
        }
    }

    public void goToSignup(){
        click(signUpLogin);
        boolean fieldsVisibility = nameField.isDisplayed() && emailField.isDisplayed();
        assertTrue(fieldsVisibility, "Signup is not Visible");

    }

    public void register(String name, String email){
        insert(nameField, name);
        insert(emailField, email);
        click(signupButton);
    }

    public void enterAccInfo(Map<String, String> accInfo){
        assertTrue(accInfoText.getText().equals("ENTER ACCOUNT INFORMATION"), "TEXT NOT MUTCH");
        assertTrue(name.isDisplayed(), "Name Is not visible");
        if (accInfo.get("gender").equals(male)){
            click(male);
        } else {
            click(female);
        }
        insert(pass, accInfo.get("password"));
        select(day, accInfo.get("day"));
        select(month, accInfo.get("month"));
        select(year, accInfo.get("year"));
        if (accInfo.get("news") == "true" && !news.isSelected()){
            click(news);
        }
        if (accInfo.get("offer") == "true" && !offer.isSelected()){
            click(offer);
        }
    }

    public void enteraddress(Map<String, String> addressFields){
        insert(firstNameField, addressFields.get("fname"));
        insert(lastNameField, addressFields.get("lname"));
        insert(company, addressFields.get("company"));
        insert(address1, addressFields.get("address1"));
        if (addressFields.get(address2) != ""){
            insert(address2, addressFields.get("address2"));
        }
        select(country, addressFields.get("country"));
        insert(state, addressFields.get("state"));
        insert(city, addressFields.get("city"));
        insert(zipcode, addressFields.get("zipcode"));
        insert(mobileNum, addressFields.get("mobilenum"));
        click(createAcc);
        assertTrue(accCreated.getText().equals("ACCOUNT CREATED!"), "Account NOT CReated");
        System.out.println("-----------------");
    }

    public void deleteAcc(String userName){
        click(continueBtn);
        boolean usrLogged = false;
        for (WebElement elem: navigationBarElems){
            if (elem.getText().equals("Logged in as " + userName)) {
                usrLogged = true;
            }
        }
        assertTrue(usrLogged, "USER IS NOT LOGGED IN");
        click(delAcc);
        assertTrue(delSuccess.getText().equals("Delete Account"), "AMAAAAAAAAAAAAAAAN");

    }

    public void select(WebElement select, String value){
        Select sel = new Select(select);
        sel.selectByVisibleText(value);
    }

    public void insert(WebElement elem, String txt){
        elem.clear();
        elem.sendKeys(txt);
    }

    public void click(WebElement elem){
        elem.click();
    }

}
