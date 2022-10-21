package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;
import webElements.single.$;

public class LoginPage extends BasePage {
    private Logs logs = new Logs();

    private final $ usernameInput = $(By.id("username"));
    private final $ passwordInput = $(By.id("password"));
    private final $ loginButtonInput = $(By.cssSelector("button[type='submit']"));
    private final $ errorMessage = $(By.id("flash"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(usernameInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(usernameInput.isDisplayed());
        softAssert.assertTrue(passwordInput.isDisplayed());
        softAssert.assertTrue(loginButtonInput.isDisplayed());
        softAssert.assertAll();
    }

    public void fillForm(String username, String password) {
        logs.info("Filling username " + username);
        usernameInput.sendKeys(username);

        logs.info("Filling password " + password);
        passwordInput.sendKeys(password);

        logs.info("Clicking on Login button");
        loginButtonInput.click();
    }

    public void verifyErrorMessage(String errorText) {
        errorMessage.waitForVisibility();
        logs.debug(errorMessage.getText());
        softAssert.assertTrue(errorMessage.isDisplayed(), "displayed");
        softAssert.assertTrue(errorMessage.getText().contains(errorText), "text");
        softAssert.assertAll();
    }
}
