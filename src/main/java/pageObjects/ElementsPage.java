package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import webElements.list.$$;
import webElements.single.$;

public class ElementsPage extends BasePage {

    private final $ buttonAddInput = $(By.xpath("//button[text()='Add Element']"));
    private final $$ buttonDeleteInput = $$(By.cssSelector("button[class='added-manually']"));

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting ElementPage to load")
    @Override
    public void waitPageToLoad() {
        waitPage(buttonAddInput, this.getClass().getSimpleName());
    }

    @Step("Verifying Elements Page")
    @Override
    public void verifyPage() {
        logs.info("verifying Button is displayed");
        Assert.assertTrue(buttonAddInput.isDisplayed());
    }

    @Step("Adding element")
    public void addElement(int n) {
        logs.info("selecting on the button add option");
        for (var i = 0; i < n; i++) {
            buttonAddInput.click();
        }
    }

    @Step("Getting size of elements")
    public int gettingSize() {
        logs.info("getting the size of the List elements");
        return buttonDeleteInput.getSize();
    }

    @Step("Deleting elements")
    public void deletingElement(int n) {
        logs.info("clicking on the delete button");
        for (var i = 0; i < n; i++) {
            buttonDeleteInput.getFirst().click();
        }
    }
}
