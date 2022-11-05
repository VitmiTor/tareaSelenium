package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class DropDownPage extends BasePage {

    private final $ title = $(By.xpath("//h3[text()='Dropdown List']"));
    private final $ selectInput = $(By.id("dropdown"));


    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(title, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {

    }

    @Step("Selecting Dropdwon option")
    public void dropDownSelect(boolean isOption1) {
        if (isOption1) {
            selectInput.selectByValue("1");
        } else {
            selectInput.selectByValue("2");
        }
    }

}
