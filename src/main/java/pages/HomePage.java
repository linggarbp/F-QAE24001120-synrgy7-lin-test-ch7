package pages;

import org.openqa.selenium.*;

import static org.openqa.selenium.By.*;

public class HomePage
{
    WebDriver driver;

    By dashboardText = className("title");
    By sortingDropdown = className("product_sort_container");
    By highToLow = xpath("//option[@value='hilo']");
    By firstItemName = xpath("(//*[@data-test='inventory-item-name'])[1]");
    By firstItemPrice = xpath("(//*[@data-test='inventory-item-price'])[1]");
    By addToCartFirstItemButton = id("add-to-cart-sauce-labs-backpack");
    By secondItemName = xpath("(//*[@data-test='inventory-item-name'])[2]");
    By secondItemPrice = xpath("(//*[@data-test='inventory-item-price'])[2]");
    By addToCartSecondItemButton = id("add-to-cart-sauce-labs-bike-light");
    By cartBadge = className("shopping_cart_badge");
    By cartIcon = className("shopping_cart_link");

    public String firstProductName;
    public String secondProductName;
    public int clickCountAddToCartButton;

    public HomePage(WebDriver driver)
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

    public void CartIconIsDisplayed()
    {
        driver.findElement(cartIcon).isDisplayed();
    }

    public void SortingDropdown()
    {
        driver.findElement(sortingDropdown).click();
    }

    public void ClickHighToLow()
    {
        driver.findElement(highToLow).click();
    }

    public String GetFirstItemPrice()
    {
        WebElement element = driver.findElement(firstItemPrice);

        String elementText = element.getText();
        String price = elementText.substring(1);
        return price;
    }

    public String GetSecondItemPrice()
    {
        WebElement element = driver.findElement(secondItemPrice);

        String elementText = element.getText();
        String price = elementText.substring(1);
        return price;
    }

    public void ClickAddToCartFirstItem()
    {
        driver.findElement(addToCartFirstItemButton).click();
        firstProductName = driver.findElement(firstItemName).getText();
        clickCountAddToCartButton++;
    }

    public void ClickAddToCartSecondItem()
    {
        driver.findElement(addToCartSecondItemButton).click();
        secondProductName = driver.findElement(secondItemName).getText();
        clickCountAddToCartButton++;
    }

    public String GetCartBadge()
    {
        return driver.findElement(cartBadge).getText();
    }

    public void ClickCartIcon()
    {
        driver.findElement(cartIcon).click();
    }
}