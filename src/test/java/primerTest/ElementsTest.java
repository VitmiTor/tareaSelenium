package primerTest;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ElementsPage;

public class ElementsTest extends BaseTest {
    private ElementsPage elementsPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goAddElementsPage();
    }

    @Test(groups = smoke)
    public void addElementsTest() {
        var addedElements = 10;
        elementsPage.addElement(addedElements);
        Assert.assertEquals(elementsPage.gettingSize(), addedElements);
        var deletedElements = 8;
        elementsPage.deletingElement(deletedElements);
        Assert.assertEquals(elementsPage.gettingSize(), addedElements - deletedElements);
    }

    @Override
    protected void initPages(WebDriver driver) {
        elementsPage = new ElementsPage(driver);
    }
}
