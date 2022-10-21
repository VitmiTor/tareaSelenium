package webElements.list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webElements.single.$;

import java.util.List;

public class $$ implements IListActions {
    private final By locator;
    private final WebDriver driver;

    private List<WebElement> webElementList;

    public $$(By locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
    }

    public $ getElementIndex(int n) {
        findElements();
        var webElement = webElementList.get(n);
        return new $(webElement, driver);
    }

    public $ getFirst() {
        return getElementIndex(0);
    }

    public int getSize() {
        findElements();
        var tam = webElementList.size();
        return tam;
    }

    public $ getLast() {
        return getElementIndex(webElementList.size() - 1);
    }

    private void findElements() {
        webElementList = driver.findElements(locator);
    }

    @Override
    public void clickAll() {
        findElements();
        for (var elements : webElementList) {
            elements.click();
        }
    }
}
