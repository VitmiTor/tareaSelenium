package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import webElements.single.$;

public class SuccesLoginPage extends BasePage {

    private final $ title = $(By.className("icon-lock"));

    public SuccesLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(title, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        logs.info("verifying title is displayed");
        Assert.assertTrue(title.isDisplayed());
    }
}
