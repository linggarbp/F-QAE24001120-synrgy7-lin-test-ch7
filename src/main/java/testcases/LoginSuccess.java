package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginSuccess
{
    WebDriver driver;

    @BeforeClass
    public void SetUp()
    {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void AALoginTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        Assert.assertEquals(loginPage.GetCurrentURL(),"https://www.saucedemo.com/");
        loginPage.UsernameFieldIsDisplayed();
        loginPage.PasswordFieldIsDisplayed();
        loginPage.LoginButtonIsDisplayed();
        loginPage.InputUsername("standard_user");
        loginPage.InputPassword("secret_sauce");
        loginPage.ClickLoginButton();
        Assert.assertEquals(homePage.GetCurrentURL(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(homePage.GetDashboardText(),"Products");
        homePage.CartIconIsDisplayed();
    }

    @AfterClass
    public void TakeDown()
    {
        driver.quit();
    }
}