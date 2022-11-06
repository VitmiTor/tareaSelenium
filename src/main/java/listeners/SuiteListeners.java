package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import utilities.FileManager;
import utilities.Logs;

public class SuiteListeners implements ISuiteListener {
    private final Logs logs = new Logs();

    @Override
    public void onStart(ISuite suite) {
        new FileManager().deleteScreenShotDirectory();
        new FileManager().redirectStdErr();
        logs.startSuite(suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        logs.info("terminando la suite");
    }
}