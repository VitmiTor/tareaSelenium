package base;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import utilities.DriverManager;
import utilities.Logs;
import utilities.Utilities;

@Listeners({SuiteListeners.class, TestListeners.class})
public class BaseTest {
    protected final Logs logs = new Logs();
    private final DriverManager driverManager = new DriverManager();
    protected SoftAssert softAssert;
    protected final String smoke = "smoke";
    protected WebDriver driver;
    protected final String regression = "regression";
    protected Utilities utilities = new Utilities();
    protected final String browsername = "Chrome";
    protected final String mainUrl = "http://the-internet.herokuapp.com/";

    @BeforeMethod(alwaysRun = true, description = "Master precondition")
    public void setUpBase() {
        softAssert = new SoftAssert();
        driver = driverManager.createDriver();

        logs.info("ingresando a la url");
        driver.get(mainUrl);
        logs.info("waiting 2 seconds");
        utilities.waitSeconds(2);
    }

    protected void setDriver(ITestResult result) {
        var currentClass = result.getInstance();
        driver = ((BaseTest) currentClass).getDriver(); //for the test listeners
    }

    @AfterMethod
    public void tearDownBase() {
        logs.debug("Killing the driver");
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
