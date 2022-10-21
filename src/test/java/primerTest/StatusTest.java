package primerTest;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.StatusPage;

public class StatusTest extends BaseTest {
    private StatusPage statusPage;

    @BeforeMethod
    public void setUp() {
        commonFlows.goStatusPage();
    }

    @Test
    public void statusTest() {
        statusPage.status404();
        statusPage.goBack();
        statusPage.verifyUrl();
    }

    @Override
    protected void initPages(WebDriver driver) {
        statusPage = new StatusPage(driver);
    }


}
