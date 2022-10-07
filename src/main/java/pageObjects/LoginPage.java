package pageObjects;

import base.BasePage;
import locators.CustomLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final CustomLocators usernameInput = new CustomLocators(By.id("username"), driver);
    private final CustomLocators passwordInput = new CustomLocators(By.id("password"), driver);
    private final CustomLocators buttonInput = new CustomLocators(By.cssSelector("button[type='submit']"), driver);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {

    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue();
        softAssert.assertTrue();
        softAssert.assertAll();
    }

    public void fillForm(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        buttonInput.click();
    }

}
