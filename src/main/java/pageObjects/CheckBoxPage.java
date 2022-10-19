package pageObjects;

import base.BasePage;
import locators.CustomLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utilities;

public class CheckBoxPage extends BasePage {
    private final CustomLocators checkBox1 = new CustomLocators(By.cssSelector("input[type='checkboxes']"), driver);
    Utilities utilities = new Utilities();

    public CheckBoxPage(WebDriver driver) {
        super(driver, 3);
    }

    @Override
    public void waitPageToLoad() {

    }

    @Override
    public void verifyPage() {

    }
}
