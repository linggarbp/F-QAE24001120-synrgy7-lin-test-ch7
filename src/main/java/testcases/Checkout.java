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
import pages.*;
import pages.CartPage;
import pages.HomePage;
import pages.InformationPage;
import pages.LoginPage;

import java.time.Duration;

import static org.openqa.selenium.By.*;

public class Checkout
{
    WebDriver driver;
    String firstProductName;
    String secondProductName;

    @BeforeClass
    public void SetUp()
    {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().minimize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void AALoginTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(id("user-name")));
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

    @Test
    public void BBAddToCartTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        InformationPage informationPage = new InformationPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(className("title")));
        homePage.ClickAddToCartFirstItem();
        homePage.ClickAddToCartSecondItem();
        firstProductName = homePage.firstProductName;
        secondProductName = homePage.secondProductName;
        int totalProductInCart = Integer.parseInt(homePage.GetCartBadge());
        Assert.assertEquals(totalProductInCart, homePage.clickCountAddToCartButton);
        homePage.ClickCartIcon();

        wait.until(ExpectedConditions.visibilityOfElementLocated(className("title")));
        Assert.assertEquals(cartPage.GetCurrentURL(),"https://www.saucedemo.com/cart.html");
        Assert.assertEquals(cartPage.GetDashboardText(),"Your Cart");
        Assert.assertEquals(cartPage.GetFirstItemCart(),firstProductName);
        Assert.assertEquals(cartPage.GetSecondItemCart(),secondProductName);
        cartPage.ClickCheckoutButton();
        Assert.assertEquals(informationPage.GetCurrentURL(),"https://www.saucedemo.com/checkout-step-one.html");
    }

    @Test
    public void CCInformationTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        InformationPage informationPage = new InformationPage(driver);
        OverviewPage overviewPage = new OverviewPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(className("title")));
        Assert.assertEquals(informationPage.GetDashboardText(),"Checkout: Your Information");
        informationPage.CheckoutFormIsDisplayed();
        informationPage.InputFirstName("Linggar");
        informationPage.InputLastName("Bhakti Pratama");
        informationPage.InputPostalCode("61171");
        informationPage.ClickContinueButton();
        Assert.assertEquals(overviewPage.GetCurrentURL(),"https://www.saucedemo.com/checkout-step-two.html");
    }

    @Test
    public void DDOverviewTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        OverviewPage overviewPage = new OverviewPage(driver);
        CompletePage completePage = new CompletePage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(className("title")));
        Assert.assertEquals(overviewPage.GetDashboardText(),"Checkout: Overview");
        Assert.assertEquals(overviewPage.GetFirstItemInCart(),firstProductName);
        Assert.assertEquals(overviewPage.GetSecondItemInCart(),secondProductName);
        overviewPage.ClickFinishButton();
        Assert.assertEquals(completePage.GetCurrentURL(),"https://www.saucedemo.com/checkout-complete.html");
    }

    @Test
    public void EECheckoutTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        CompletePage completePage = new CompletePage(driver);
        HomePage homePage = new HomePage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(className("title")));
        Assert.assertEquals(completePage.GetDashboardText(),"Checkout: Complete!");
        completePage.CompleteIconIsDisplayed();
        Assert.assertEquals(completePage.GetHeaderText(),"Thank you for your order!");
        Assert.assertEquals(completePage.GetDescriptionText(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        completePage.ClickBackButton();
        Assert.assertEquals(homePage.GetCurrentURL(),"https://www.saucedemo.com/inventory.html");
    }

    @AfterClass
    public void TakeDown()
    {
        driver.quit();
    }
}