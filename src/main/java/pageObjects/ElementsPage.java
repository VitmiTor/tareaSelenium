package pageObjects;

import base.BasePage;
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

    public void addElement(int n) {
        for (var i = 0; i < n; i++) {
            buttonAddInput.click();
        }
    }

    public void gettingSize() {
        var number = buttonDeleteInput.getSize();
        
        logs.info(String.valueOf(number));
    }

    public void deletingElement(int n) {
        for (var i = 0; i < n; i++) {
            buttonDeleteInput.getElementIndex(i);
        }
    }


}
