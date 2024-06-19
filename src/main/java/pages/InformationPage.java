package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class InformationPage
{
    WebDriver driver;

    By dashboardText = className("title");
    By checkoutForm = className("checkout_info_container");
    By firstNameField = id("first-name");
    By lastNameField = id("last-name");
    By postalCodeField = id("postal-code");
    By continueButton = id("continue");

    public InformationPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String GetCurrentURL()
    {
        return driver.getCurrentUrl();
    }

    public String GetDashboardText()
    {
        return driver.findElement(dashboardText).getText();
    }

    public void CheckoutFormIsDisplayed()
    {
        driver.findElement(checkoutForm).isDisplayed();
    }

    public void InputFirstName(String firstName)
    {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void InputLastName(String lastName)
    {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void InputPostalCode(String postalCode)
    {
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void ClickContinueButton()
    {
        driver.findElement(continueButton).click();
    }
}