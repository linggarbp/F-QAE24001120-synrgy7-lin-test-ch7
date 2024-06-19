package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class LoginPage
{
    WebDriver driver;

    By usernameField = id("user-name");
    By passwordField = id("password");
    By loginButton = id("login-button");
    By errorMessage = className("error-message-container");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String GetCurrentURL()
    {
        return driver.getCurrentUrl();
    }

    public void UsernameFieldIsDisplayed()
    {
        driver.findElement(usernameField).isDisplayed();
    }

    public void PasswordFieldIsDisplayed()
    {
        driver.findElement(passwordField).isDisplayed();
    }

    public void LoginButtonIsDisplayed()
    {
        driver.findElement(loginButton).isDisplayed();
    }

    public void InputUsername(String username)
    {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void InputPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void ClickLoginButton()
    {
        driver.findElement(loginButton).click();
    }

    public void ErrorMessageIsDisplayed()
    {
        driver.findElement(errorMessage).isDisplayed();
    }

    public String ErrorGetText()
    {
        return driver.findElement(errorMessage).getText();
    }
}