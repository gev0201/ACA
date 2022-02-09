package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercouryToursFlightPage {

    WebDriver driver;
    @FindBy(linkText = "Flights")
    WebElement flights;

    public MercouryToursFlightPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFlights() {
        this.flights.click();
    }

}
