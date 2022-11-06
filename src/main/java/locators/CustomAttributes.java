package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomAttributes {
    private WebElement element;

    public void findElement(By locator, WebDriver driver) {
        element.findElement(locator);
    }

    public String getText(By locator, WebDriver driver) {
        findElement(locator, driver);
        return element.getText();
    }
}
