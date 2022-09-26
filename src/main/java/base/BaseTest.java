package base;

import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utilities.Logs;

public class BaseTest {
    protected final Logs logs = new Logs();
    protected SoftAssert softAssert;
    protected final String smoke = "smoke";
    protected final String regression = "regression";

    @BeforeMethod
    public void setUpBase() {
        softAssert = new SoftAssert();
        logs.info("Setup padre");
    }

}
