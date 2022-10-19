package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomLocators {
    private final By locator;
    private final WebDriver driver;
    private final CustomActions customActions = new CustomActions();
    private final CustomVerifications customVerifications = new CustomVerifications();
    private final CustomAttributes customAttributes = new CustomAttributes();
    private WebDriverWait wait;

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

    public boolean verifyIsDisplayed() {
        return customVerifications.verifyDisplayed(locator, driver);
    }

    public String getText() {
        return customAttributes.getText(locator, driver);
    }

    public CustomLocators waitForVisibility(int timeOut) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    public CustomLocators waitForVisibility() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }
}
