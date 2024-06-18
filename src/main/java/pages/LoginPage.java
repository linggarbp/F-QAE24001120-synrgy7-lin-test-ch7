package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    WebDriver driver;

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
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

    public void ErrorMessageIsDisplayed()
    {
        driver.findElement(errorMessage).isDisplayed();
    }

    public String ErrorGetText()
    {
        return driver.findElement(errorMessage).getText();
    }
}