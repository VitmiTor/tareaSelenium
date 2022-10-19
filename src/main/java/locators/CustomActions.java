package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomActions {

    private WebElement element;

    public void findElement(By locator, WebDriver driver) {
        element.findElement(locator);
    }

    public CustomActions click(By locator, WebDriver driver) {
        findElement(locator, driver);
        element.click();
        return this;
    }

    public CustomActions sendKeys(By locator, WebDriver driver, String text) {
        findElement(locator, driver);
        element.sendKeys(text);
        return this;
    }
}
