package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    protected final Logs logs = new Logs();

    public WebDriver createDriver() {
        var browserName = System.getProperty("browser");
        if (browserName == null) {
            logs.debug("Setting default local browser to Chrome");
            browserName = "Chrome";
        }
        WebDriver driver;
        switch (browserName) {
            case "Chrome":
                logs.debug("Initializing Edge driver");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Edge":
                logs.debug("Initializing Edge driver");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "Safari":
                logs.debug("Initializing Safari driver");
                WebDriverManager.safaridriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                return null;
        }

        logs.debug("Initializing the driver");
        WebDriverManager.chromedriver().setup();
        logs.debug("Maximizando Windows");
        driver.manage().window().maximize();
        logs.debug("Eliminado cookies");
        driver.manage().deleteAllCookies();

        return driver;
    }
}
