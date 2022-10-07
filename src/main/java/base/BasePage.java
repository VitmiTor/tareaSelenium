package base;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public abstract class BasePage {
    protected final WebDriver driver;
    private final int timeOut;

    private final int defaultTimeOut = 5;

    protected SoftAssert softAssert;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.timeOut = defaultTimeOut;
        softAssert = new SoftAssert();
    }

    public BasePage(WebDriver driver, int timeOut) {
        this.driver = driver;
        this.timeOut = timeOut;
        softAssert = new SoftAssert();
    }

    public abstract void waitPageToLoad();

    public abstract void verifyPage();

}
