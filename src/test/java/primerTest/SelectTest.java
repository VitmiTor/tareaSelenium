package primerTest;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.DropDownPage;

public class SelectTest extends BaseTest {
    DropDownPage dropDownPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.gotSelectPage();
    }

    @Test(groups = smoke)
    public void selectTest() {
        dropDownPage.dropDownSelect(true);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException interruptedException) {
            interruptedException.getLocalizedMessage();
        }
    }

    @Override
    protected void initPages(WebDriver driver) {
        dropDownPage = new DropDownPage(driver);
    }
}
