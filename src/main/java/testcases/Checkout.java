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

public class Checkout
{
    WebDriver driver;
    String firstProductName;
    String secondProductName;

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

    @Test
    public void BBAddToCartTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        InformationPage informationPage = new InformationPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='title']")));
        homePage.ClickAddToCartFirstItem();
        homePage.ClickAddToCartSecondItem();
        firstProductName = homePage.firstProductName;
        secondProductName = homePage.secondProductName;
        int productsInCart = Integer.parseInt(homePage.GetCartBadge());
        Assert.assertEquals(productsInCart, homePage.clickCountAddToCartButton);
        homePage.ClickCartIcon();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='title']")));
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        InformationPage informationPage = new InformationPage(driver);
        OverviewPage overviewPage = new OverviewPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='title']")));
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        OverviewPage overviewPage = new OverviewPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='title']")));
        Assert.assertEquals(overviewPage.GetDashboardText(),"Checkout: Overview");
        Assert.assertEquals(overviewPage.GetFirstItemInCart(),firstProductName);
        Assert.assertEquals(overviewPage.GetSecondItemInCart(),secondProductName);
        overviewPage.ClickFinishButton();
        Assert.assertEquals(checkoutPage.GetCurrentURL(),"https://www.saucedemo.com/checkout-complete.html");
    }

    @Test
    public void EECheckoutTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        HomePage homePage = new HomePage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='title']")));
        Assert.assertEquals(checkoutPage.GetDashboardText(),"Checkout: Complete!");
        checkoutPage.CompleteIconIsDisplayed();
        Assert.assertEquals(checkoutPage.GetGreetingText(),"Thank you for your order!");
        Assert.assertEquals(checkoutPage.GetDescriptionText(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        checkoutPage.ClickBackButton();
        Assert.assertEquals(homePage.GetCurrentURL(),"https://www.saucedemo.com/inventory.html");
    }

    @AfterClass
    public void TakeDown()
    {
        driver.quit();
    }
}