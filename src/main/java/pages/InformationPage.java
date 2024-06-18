package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class InformationPage
{
    WebDriver driver;

    By dashboardText = xpath("//*[@data-test='title']");
    By checkoutForm = xpath("//*[@class='checkout_info']");
    By firstNameField = id("first-name");
    By lastNameField = id("last-name");
    By postalCodeField = id("postal-code");
    By continueButton = xpath("//*[@data-test='continue']");

    public InformationPage(WebDriver driver)
    {
        this.driver=driver;
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