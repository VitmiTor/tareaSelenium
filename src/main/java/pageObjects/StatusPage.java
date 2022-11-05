package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import webElements.single.$;

public class StatusPage extends BasePage {

    private final $ title = $(By.xpath("//h3[text()='Status Codes']"));
    private final $ link404 = $(By.linkText("404"));
    private final $ linkHere = $(By.linkText("here"));

    public StatusPage(WebDriver driver) {
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

    @Step("Clciking on status code 404")
    public void status404() {
        link404.click();
        linkHere.waitForVisibility();
    }

    @Step("Clicking on go Back")
    public void goBack() {
        logs.info("clicking link here to go back");
        linkHere.click();
    }

    @Step("verifying URL")
    public void verifyUrl() {
        logs.info("verifying URL");
        link404.waitForVisibility();
        var mainmUrl = "http://the-internet.herokuapp.com/status_codes";
        Assert.assertEquals(mainmUrl, driver.getCurrentUrl());
    }
}
