package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class CartPage {
    WebDriver driver;

    By dashboardText = xpath("//*[@data-test='title']");
    By firstItemCart = xpath("(//*[@data-test='inventory-item-name'])[1]");
    By secondItemCart = xpath("(//*[@data-test='inventory-item-name'])[2]");
    By checkoutButton = xpath("//*[@data-test='checkout']");

    public CartPage(WebDriver driver)
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

    public String GetFirstItemCart()
    {
        return driver.findElement(firstItemCart).getText();
    }

    public String GetSecondItemCart()
    {
        return driver.findElement(secondItemCart).getText();
    }

    public void ClickCheckoutButton()
    {
        driver.findElement(checkoutButton).click();
    }
}
