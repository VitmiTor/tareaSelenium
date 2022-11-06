package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomVerifications {
    private WebElement element;

    public void findElement(By locator, WebDriver driver) {
        element = driver.findElement(locator);
    }

    public boolean verifyDisplayed(By locator, WebDriver driver) {
        element = driver.findElement(locator);
        return element.isDisplayed();
    }
}
