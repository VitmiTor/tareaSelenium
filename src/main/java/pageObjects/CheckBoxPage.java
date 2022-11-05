package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.list.$$;
import webElements.single.$;

public class CheckBoxPage extends BasePage {

    private final $ title = $(By.xpath("//h3[text()='Checkboxes']"));

    private final $$ checkBoxes = $$(By.cssSelector("input[type='checkbox']"));

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(title, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(title.isDisplayed());
        softAssert.assertAll();
    }

    @Step("CheckBox First checkBox")
    public void clickFirst() {
        checkBoxes.getFirst().click();
    }

    @Step("CheckBox clicking the last checkBox")
    public void clickLast() {
        checkBoxes.getLast().click();
    }

    @Step("Verifying if the checkBoxes is selected or not")
    public void verifyCheckBoxes(boolean checkBox1, boolean checkBox2) {
        softAssert.assertEquals(checkBoxes.getFirst().isSelected(), checkBox1);
        softAssert.assertEquals(checkBoxes.getLast().isSelected(), checkBox2);
        softAssert.assertAll();
    }
}
