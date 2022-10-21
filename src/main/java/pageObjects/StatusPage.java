package pageObjects;

import base.BasePage;
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

    }

    public void status404() {
        link404.click();
        linkHere.waitForVisibility();
        Assert.assertTrue(linkHere.isDisplayed());
    }

    public void goBack() {
        linkHere.click();
    }

    public void verifyUrl() {
        link404.waitForVisibility();
        var mainmUrl = "http://the-internet.herokuapp.com/status_codes";
        Assert.assertEquals(mainmUrl, driver.getCurrentUrl());
    }

}
