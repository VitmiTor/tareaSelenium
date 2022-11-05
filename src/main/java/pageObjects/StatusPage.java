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

    @Step("Waiting StatusPage to load")
    @Override
    public void waitPageToLoad() {
        waitPage(title, this.getClass().getSimpleName());
    }

    @Step("Verifying Status Page to load")
    @Override
    public void verifyPage() {
        logs.info("verifying title is displayed");
        Assert.assertTrue(title.isDisplayed());
    }

    @Step("Clicking on status code 404")
    public void status404() {
        logs.info("Clicking on status code 404");
        link404.click();
        logs.info("waiting for Link Here");
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
        logs.info("Comparing URLs");
        Assert.assertEquals(mainmUrl, driver.getCurrentUrl());
    }
}
