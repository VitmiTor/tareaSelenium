package primerTest;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @Test(groups = {smoke, regression})
    public void login() {
        var credentials = dataProvider.getValidCredentials();


    }

    @Test(groups = {regression})
    public void invalidCredentials() {
        var errorText = "Your username is invalid!";
        var credentials = dataProvider.getInvalidValidCredentials();

    }

    @Test(groups = {regression})

    public void exercise3() {

    }

    @Test(groups = {regression})
    public void exercise4() {

    }

    @Test(groups = {smoke, regression})
    public void exercise5() {

    }

    @Override
    protected void initPages() {
        loginPage = new LoginPage(driver);

    }
}
