package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class OverviewPage
{
    WebDriver driver;

    By dashboardText = className("title");
    By firstItemInCart = xpath("(//*[@data-test='inventory-item-name'])[1]");
    By secondItemInCart = xpath("(//*[@data-test='inventory-item-name'])[2]");
    By finishButton = id("finish");

    public OverviewPage(WebDriver driver)
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

    public String GetFirstItemInCart()
    {
        return driver.findElement(firstItemInCart).getText();
    }

    public String GetSecondItemInCart()
    {
        return driver.findElement(secondItemInCart).getText();
    }

    public void ClickFinishButton()
    {
        driver.findElement(finishButton).click();
    }
}