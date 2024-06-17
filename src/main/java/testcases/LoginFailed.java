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
import pages.LoginPage;

import java.time.Duration;

public class LoginFailed {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginTest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        LoginPage loginPage = new LoginPage(driver);

        //explicit wait untuk menunggu element terlihat di layar
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        //assertion 1 : cek current URL apakah sudah sesuai dengan URL Login Page
        Assert.assertEquals(loginPage.getCurrentURL(),"https://www.saucedemo.com/");

        //assertion 2 : cek apakah username field, password field, dan login button muncul
        loginPage.usernameFieldIsDisplayed();
        loginPage.passwordFieldIsDisplayed();
        loginPage.loginButtonIsDisplayed();

        //method action element
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("passwordtestnegative");
        loginPage.clickLoginButton();

        //assertion 3 : cek current URL apakah URL halaman tidak berubah
        Assert.assertEquals(loginPage.getCurrentURL(),"https://www.saucedemo.com/");

        //assertion 4 : cek apakah Error Warning muncul
        loginPage.errorWarningIsDisplayed();

        //assertion 5 : cek apakah teks Error sudah sesuai ekspektasi
        Assert.assertEquals(loginPage.errorGetText(),"Epic sadface: Username and password do not match any user in this service");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}