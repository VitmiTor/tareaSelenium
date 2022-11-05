package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.list.$$;
import webElements.single.$;

public class ElementsPage extends BasePage {

    private final $ buttonAddInput = $(By.xpath("//button[text()='Add Element']"));
    private final $$ buttonDeleteInput = $$(By.cssSelector("button[class='added-manually']"));

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(buttonAddInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {

    }

    @Step("Adding element")
    public void addElement(int n) {
        for (var i = 0; i < n; i++) {
            buttonAddInput.click();
        }
    }

    @Step("Getting size of elements")
    public int gettingSize() {
        return buttonDeleteInput.getSize();
    }

    @Step("Deleting elements")
    public void deletingElement(int n) {
        for (var i = 0; i < n; i++) {
            buttonDeleteInput.getFirst().click();
        }
    }
}
