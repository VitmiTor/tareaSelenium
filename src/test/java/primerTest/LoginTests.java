package primerTest;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CheckBoxPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SuccesLoginPage;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    private CheckBoxPage checkBoxPage;
    private HomePage homePage;
    private SuccesLoginPage succesLoginPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goLoginPage();
    }

    @Test(groups = {smoke, regression})
    public void loginTest() {
        var credentials = dataProvider.getInvalidValidCredentials();
        loginPage.fillForm(credentials.getUsername(), credentials.getPassword());
        succesLoginPage.waitPageToLoad();
    }

    @Test
    public void verifyUXTest() {
        loginPage.verifyPage();
    }

    @Test(groups = {regression})
    public void invalidCredentialsTest() {
        var errorText = "Your username is invalid!";
        var credentials = dataProvider.getInvalidValidCredentials();

        loginPage.fillForm(credentials.getUsername(), credentials.getPassword());
        loginPage.verifyErrorMessage(errorText);
    }

    @Test(groups = {regression})
    public void exercise4() {

    }

    @Test(groups = {smoke, regression})
    public void exercise5() {

    }

    @Override
    protected void initPages(WebDriver driver) {
        loginPage = new LoginPage(driver);
        checkBoxPage = new CheckBoxPage(driver);
        succesLoginPage = new SuccesLoginPage(driver);
    }
}
