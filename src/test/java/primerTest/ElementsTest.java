package primerTest;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ElementsPage;

public class ElementsTest extends BaseTest {
    private ElementsPage elementsPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goAddElementsPage();
    }

    @Test
    public void addElementsTest() {
        elementsPage.addElement(10);
        elementsPage.gettingSize();
        elementsPage.deletingElement(8);
        elementsPage.gettingSize();
    }

    @Override
    protected void initPages(WebDriver driver) {
        elementsPage = new ElementsPage(driver);
    }
}
