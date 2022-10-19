package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;
import webElements.$;

public class LoginPage extends BasePage {
    private Logs logs = new Logs();
    private final $ loginLinkInput = $(By.linkText("Form Authentication"));
    private final $ usernameInput = $(By.id("username"));
    private final $ passwordInput = $(By.id("password"));
    private final $ loginButtonInput = $(By.cssSelector("button[type='submit']"));

    public LoginPage(WebDriver driver) {
        super(driver, 5);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(loginLinkInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(loginLinkInput.isDisplayed());
        softAssert.assertTrue(usernameInput.isDisplayed());
        softAssert.assertTrue(passwordInput.isDisplayed());
        softAssert.assertTrue(loginButtonInput.isDisplayed());
        softAssert.assertAll();
    }

    public void fillForm(String username, String password) {
        logs.info("Clicking the login link");
        loginLinkInput.click();

        logs.info("Filling usernema " + username);
        usernameInput.sendKeys(username);

        logs.info("Filling password " + password);
        passwordInput.sendKeys(password);

        logs.info("Clickin on Login button");
        loginButtonInput.click();
    }
}
