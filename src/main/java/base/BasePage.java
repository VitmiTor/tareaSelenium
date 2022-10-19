package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.Logs;
import webElements.$;

public abstract class BasePage {
    protected final WebDriver driver;
    private final int timeOut;
    private final Logs logs = new Logs();

    private final int defaultTimeOut = 5;

    protected SoftAssert softAssert;

    public BasePage(WebDriver driver, int timeOut) {
        this.driver = driver;
        this.timeOut = timeOut;
        softAssert = new SoftAssert();
    }

    protected void waitPage($ element, String pageName) {
        
    }

    protected $ $(By locator) {
        return new $(locator, driver);
    }

    public abstract void waitPageToLoad();

    public abstract void verifyPage();

}
