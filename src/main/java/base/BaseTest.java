package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utilities.DriverManager;
import utilities.Logs;
import utilities.Utilities;

public class BaseTest {
    protected final Logs logs = new Logs();
    private final DriverManager driverManager = new DriverManager();
    protected SoftAssert softAssert;
    protected final String smoke = "smoke";
    protected WebDriver driver;
    protected final String regression = "regression";
    protected Utilities utilities = new Utilities();
    protected final String browsername = "Chrome";
    protected final String mainUrl = "http://the-internet.herokuapp.com/login";

    @BeforeMethod(alwaysRun = true, description = "Master precondition")
    public void setUpBase() {
        softAssert = new SoftAssert();
        driver = driverManager.createDriver();

        logs.info("ingresando a la url");
        driver.get(mainUrl);
        logs.info("waiting 2 seconds");
        utilities.waitSeconds(2);
    }

    @AfterMethod
    public void tearDownBase() {
        logs.debug("Killing the driver");
        driver.quit();
    }
}
