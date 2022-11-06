package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class LoginPage extends BasePage {

    private final $ usernameInput = $(By.id("username"));
    private final $ passwordInput = $(By.id("password"));
    private final $ loginButtonInput = $(By.cssSelector("button[type='submit']"));
    private final $ errorMessage = $(By.id("flash"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verifying loginPage to Load")
    @Override
    public void waitPageToLoad() {
        waitPage(usernameInput, this.getClass().getSimpleName());
    }

    @Step("Verifying loginPage")
    @Override
    public void verifyPage() {
        logs.info("verifying elements of the form");
        softAssert.assertTrue(usernameInput.isDisplayed());
        softAssert.assertTrue(passwordInput.isDisplayed());
        softAssert.assertTrue(loginButtonInput.isDisplayed());
        softAssert.assertAll();
    }

    @Step("filling form")
    public void fillForm(String username, String password) {
        logs.info("Filling username " + username);
        usernameInput.sendKeys(username);

        logs.info("Filling password " + password);
        passwordInput.sendKeys(password);

        logs.info("Clicking on Login button");
        loginButtonInput.click();
    }

    @Step("Verifying Error Message")
    public void verifyErrorMessage(String errorText) {
        errorMessage.waitForVisibility();
        logs.info(errorMessage.getText());
        softAssert.assertTrue(errorMessage.isDisplayed(), "displayed");
        logs.info("Comparing Error Text Message");
        softAssert.assertTrue(errorMessage.getText().contains(errorText), "text");
        softAssert.assertAll();
    }
}
