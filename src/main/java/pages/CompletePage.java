package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class CompletePage
{
    WebDriver driver;

    By dashboardText = className("title");
    By completeIcon = className("pony_express");
    By headerText = className("complete-header");
    By descriptionText = className("complete-text");
    By backButton = id("back-to-products");

    public CompletePage(WebDriver driver)
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

    public void CompleteIconIsDisplayed()
    {
        driver.findElement(completeIcon).isDisplayed();
    }

    public String GetHeaderText()
    {
        return driver.findElement(headerText).getText();
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