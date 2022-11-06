package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import webElements.single.$;

public class DropDownPage extends BasePage {

    private final $ title = $(By.xpath("//h3[text()='Dropdown List']"));
    private final $ selectInput = $(By.id("dropdown"));


    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting DropdownPage to load")
    @Override
    public void waitPageToLoad() {
        waitPage(title, this.getClass().getSimpleName());
    }

    @Step("Verifying Dropdown Page")
    @Override
    public void verifyPage() {
        logs.info("verifying title is displayed");
        Assert.assertTrue(title.isDisplayed());
    }

    @Step("Selecting Dropdwon option")
    public void dropDownSelect(boolean isOption1) {
        logs.info("selecting dropdown element");
        if (isOption1) {
            logs.info("selecting on the first option");
            selectInput.selectByValue("1");
        } else {
            logs.info("selecting on the second option");
            selectInput.selectByValue("2");
        }
    }

}
