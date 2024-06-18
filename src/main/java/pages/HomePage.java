package pages;

import org.openqa.selenium.*;

import static org.openqa.selenium.By.xpath;

public class HomePage
{
    WebDriver driver;

    By dashboardText = xpath("//*[@data-test='title']");
    By cartIcon = xpath("//*[@data-test='shopping-cart-link']");
    By sortingDropdown = xpath("//*[@data-test='product-sort-container']");
    By highToLow = xpath("//*[@value='hilo']");
    By firstItemPrice = xpath("(//*[@data-test='inventory-item-price'])[1]");
    By secondItemPrice = xpath("(//*[@data-test='inventory-item-price'])[2]");
    By addToCartFirstItemButton = xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']");
    By addToCartSecondItemButton = xpath("//button[@data-test='add-to-cart-sauce-labs-bike-light']");
    By cartBadge = xpath("//*[@data-test='shopping-cart-badge']");
    By firstItemName = xpath("(//*[@data-test='inventory-item-name'])[1]");
    By secondItemName = xpath("(//*[@data-test='inventory-item-name'])[2]");

    public int clickCountAddToCartButton;
    public String firstProductName;
    public String secondProductName;

    public HomePage(WebDriver driver)
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

        // Get the text of the element
        String elementText = element.getText();

        // Split the text into words
        String[] words = elementText.split(" ");

        // Create a StringBuilder to store the modified text
        StringBuilder modifiedText = new StringBuilder();

        // Loop through each word, remove the first letter, and append to StringBuilder
        for (String word : words) {
            if (word.length() > 1) {
                modifiedText.append(word.substring(1)).append(" ");
            } else {
                // In case the word is a single letter, we just skip it or handle it accordingly
                modifiedText.append(" ");
            }
        }

        // Convert StringBuilder to String and trim the trailing space
        String price = modifiedText.toString().trim();

        return price;
    }

    public String GetSecondItemPrice()
    {
        WebElement element = driver.findElement(secondItemPrice);

        // Get the text of the element
        String elementText = element.getText();

        // Split the text into words
        String[] words = elementText.split(" ");

        // Create a StringBuilder to store the modified text
        StringBuilder modifiedText = new StringBuilder();

        // Loop through each word, remove the first letter, and append to StringBuilder
        for (String word : words) {
            if (word.length() > 1) {
                modifiedText.append(word.substring(1)).append(" ");
            } else {
                // In case the word is a single letter, we just skip it or handle it accordingly
                modifiedText.append(" ");
            }
        }

        // Convert StringBuilder to String and trim the trailing space
        String price = modifiedText.toString().trim();

        return price;
    }

    public void ClickAddToCartFirstItem()
    {
        driver.findElement(addToCartFirstItemButton).click();
        clickCountAddToCartButton++;
        firstProductName = driver.findElement(firstItemName).getText();
    }

    public void ClickAddToCartSecondItem()
    {
        driver.findElement(addToCartSecondItemButton).click();
        clickCountAddToCartButton++;
        secondProductName = driver.findElement(secondItemName).getText();
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