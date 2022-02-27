package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GooglePage {

    WebDriver driver;

    @FindBy(name = "q")
    WebElement googleInput;

    @FindBy(name = "btnK")
    WebElement googleSearchButton;


    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputSearchText(){
        googleInput.sendKeys("auto am");
    }

    public void clickGoogleSearchButton(){
        googleSearchButton.click();
    }

}
