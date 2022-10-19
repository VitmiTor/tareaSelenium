package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class $ implements IActions, IVerifications {
    private final By locator;
    private final WebDriver driver;
    private WebElement webElement;

    public $(By locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
    }


    @Override
    public $ click() {
        findElement();
        webElement.click();
        return this;
    }

    @Override
    public $ sendKeys(String text) {
        findElement();
        webElement.sendKeys(text);
        return this;
    }

    @Override
    public boolean isDisplayed() {
        findElement();
        return webElement.isDisplayed();
    }

    @Override
    public boolean isEnable() {
        findElement();
        return webElement.isEnabled();
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    private void findElement() {
        webElement = driver.findElement(locator);
    }


}
