import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        
    }

    @Test(groups = {regression})
    public void login() {

        utilities.waitSeconds(1);
        logs.info("ok");
    }
}
