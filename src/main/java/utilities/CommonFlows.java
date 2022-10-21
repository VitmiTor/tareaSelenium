package utilities;

import data.DataProvider;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class CommonFlows {

    private final WebDriver driver;
    private final Logs logs = new Logs();
    private final String mainUrl = "http://the-internet.herokuapp.com/";
    private final DataProvider dataProvider = new DataProvider();


    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void goLoginPage() {
        var homePage = new HomePage(driver);
        var loginPage = new LoginPage(driver);

        homePage.loginLinkClick();
        loginPage.waitPageToLoad();
    }

    public void goHomePage() {
        var homePage = new HomePage(driver);
        driver.get(mainUrl);
        homePage.waitPageToLoad();
    }

    public void goCheckBoxPage() {
        var homePage = new HomePage(driver);
        var checkBoxPage = new CheckBoxPage(driver);
        homePage.linkCheckBoxClick();
        checkBoxPage.waitPageToLoad();
    }

    public void goAddElementsPage() {
        var elementsPage = new ElementsPage(driver);
        var homePage = new HomePage(driver);
        homePage.addElementsLink();
        elementsPage.waitPageToLoad();
    }

    public void goStatusPage() {
        var homePage = new HomePage(driver);
        var statusPage = new StatusPage(driver);
        homePage.statusPageLink();
        statusPage.waitPageToLoad();
    }
}
