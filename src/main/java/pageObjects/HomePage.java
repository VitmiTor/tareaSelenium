package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class HomePage extends BasePage {
    private final $ title = $(By.xpath("//h1[text()='Welcome to the-internet']"));
    private final $ checkBoxLinkInput = $(By.linkText("Checkboxes"));
    private final $ loginLinkInput = $(By.linkText("Form Authentication"));
    private final $ addElementsLinkInput = $(By.linkText("Add/Remove Elements"));
    private final $ statusLinkInput = $(By.linkText("Status Codes"));
    private final $ dropdownLink = $(By.linkText("Dropdown"));

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting HomePage to load")
    @Override
    public void waitPageToLoad() {
        waitPage(title, this.getClass().getSimpleName());
    }

    @Step("Verifying Home Page")
    @Override
    public void verifyPage() {
        softAssert.assertTrue(loginLinkInput.isDisplayed());
        softAssert.assertTrue(title.isDisplayed());
        softAssert.assertTrue(checkBoxLinkInput.isDisplayed());
        softAssert.assertTrue(addElementsLinkInput.isDisplayed());
        softAssert.assertTrue(statusLinkInput.isDisplayed());
        softAssert.assertTrue(dropdownLink.isDisplayed());
        softAssert.assertAll();
    }

    @Step("Clicking Login link")
    public void loginLinkClick() {
        logs.info("Clicking login");
        loginLinkInput.click();
    }

    @Step("Clicking checkBoxLink")
    public void linkCheckBoxClick() {
        logs.info("Clicking checkBox");
        checkBoxLinkInput.click();
    }

    @Step("Clickin addElementsLink")
    public void addElementsLink() {
        logs.info("Clicking addElements Link");
        addElementsLinkInput.click();
    }

    @Step("Clicking status page")
    public void statusPageLink() {
        logs.info("Clicking status page Link");
        statusLinkInput.click();
    }

    @Step()
    public void dropdownPageLink() {
        logs.info("Clicking dropdown Link");
        dropdownLink.click();
    }
}
