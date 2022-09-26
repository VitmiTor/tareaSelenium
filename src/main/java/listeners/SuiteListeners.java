package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import utilities.Logs;

public class SuiteListeners implements ISuiteListener {
    private final Logs logs = new Logs();

    @Override
    public void onStart(ISuite suite) {
        logs.startSuite(suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        logs.info("terminando la suite");
    }
}