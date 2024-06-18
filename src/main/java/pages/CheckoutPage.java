package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class CheckoutPage
{
    WebDriver driver;

    By dashboardText = xpath("//*[@data-test='title']");
    By completeIcon = xpath("//*[@data-test='pony-express']");
    By greetingText = xpath("//*[@data-test='complete-header']");
    By descriptionText = xpath("//*[@data-test='complete-text']");
    By backButton = xpath("//*[@data-test='back-to-products']");

    public CheckoutPage(WebDriver driver)
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

    public void CompleteIconIsDisplayed()
    {
        driver.findElement(completeIcon).isDisplayed();
    }

    public String GetGreetingText()
    {
        return driver.findElement(greetingText).getText();
    }

    public String GetDescriptionText()
    {
        return driver.findElement(descriptionText).getText();
    }

    public void ClickBackButton()
    {
        driver.findElement(backButton).click();
    }
}