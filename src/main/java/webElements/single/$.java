package webElements.single;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class $ implements IActions, IVerifications, IWaits, IAttributes, ISelect {
    private By locator;
    private final WebDriver driver;
    private WebElement webElement;
    private final int defaulTimeOut = 5;
    private WebDriverWait wait;
    private boolean search = true;

    public $(By locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
    }

    public $(WebElement webElement, WebDriver driver) {
        this.webElement = webElement;
        this.driver = driver;
        this.search = false;
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

    @Override
    public String getText() {
        findElement();
        return webElement.getText();
    }

    @Override
    public String getHref() {
        findElement();
        return webElement.getAttribute("href");
    }

    @Override
    public void selectByValue(String value) {
        getSelect().selectByValue(value);
    }

    @Override
    public void selectByVisisbleText(String Text) {
        getSelect().selectByVisibleText(Text);
    }

    @Override
    public void slectByIndex(int index) {
        getSelect().deselectByIndex(index);
    }

    @Override
    public void deselectByValue(String value) {
        getSelect().deselectByValue(value);
    }

    @Override
    public void deselectByVisisbleText(String Text) {
        getSelect().deselectByVisibleText(Text);
    }

    @Override
    public void deslectByIndex(int index) {
        getSelect().deselectByIndex(index);
    }

    @Override
    public $ waitForVisibility() {
        createWait(defaulTimeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    @Override
    public $ waitForVisibility(int timeOut) {
        createWait(timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    private Select getSelect() {
        findElement();
        return new Select(webElement);
    }

    private void findElement() {
        if (search) {
            webElement = driver.findElement(locator);
        }
    }

    private void createWait(int timeOut) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
    }
}
