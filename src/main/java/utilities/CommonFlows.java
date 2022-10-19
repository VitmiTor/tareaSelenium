package utilities;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;

public class CommonFlows {
    private final WebDriver driver;
    private Logs logs = new Logs();
    private final String mainUrl = "http://the-internet.herokuapp.com/";

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void goLoginPage() {
        logs.info("ingresando a la url");
        driver.get(mainUrl);
        logs.info("waiting 2 seconds");
        var loginPage = new LoginPage(driver);//wait page to load
        loginPage.waitPageToLoad();
    }
}
