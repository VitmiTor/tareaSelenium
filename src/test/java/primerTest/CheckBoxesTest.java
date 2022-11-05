package primerTest;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CheckBoxPage;

public class CheckBoxesTest extends BaseTest {
    private CheckBoxPage checkBoxPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goCheckBoxPage();
    }

    @Test(groups = {smoke})
    public void checkboxFunctionTest() {
        checkBoxPage.verifyCheckBoxes(false, true);
        checkBoxPage.clickFirst();
        checkBoxPage.clickLast();
        checkBoxPage.verifyCheckBoxes(true, false);
    }

    @Override
    protected void initPages(WebDriver driver) {
        checkBoxPage = new CheckBoxPage(driver);
    }
}
