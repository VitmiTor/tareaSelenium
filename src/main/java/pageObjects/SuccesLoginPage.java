package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import webElements.single.$;

public class SuccesLoginPage extends BasePage {

    private final $ title = $(By.className("icon-lock"));

    public SuccesLoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting SuccessPage to load")
    @Override
    public void waitPageToLoad() {
        waitPage(title, this.getClass().getSimpleName());
    }

    @Step("Verifyign CheckBoxPage")
    @Override
    public void verifyPage() {
        logs.info("verifying title is displayed");
        Assert.assertTrue(title.isDisplayed());
    }
}
