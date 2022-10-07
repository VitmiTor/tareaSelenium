package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomLocators {
    private final By locator;
    private final WebDriver driver;


    public CustomLocators(By locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
    }

    public CustomLocators click() {
        driver.findElement(locator).click();
        return this;
    }

    public CustomLocators sendKeys(String text) {
        driver.findElement(locator).sendKeys(text);
        return this;
    }

}
