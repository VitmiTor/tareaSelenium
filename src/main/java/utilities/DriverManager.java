package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;

public class DriverManager {
    protected final Logs logs = new Logs();
    private final String screenShotPath = "src/test/resources/screenshots";

    private static WebDriver staticdriver;

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
        staticdriver = driver;

        return driver;
    }

    public void getScreenshot(WebDriver driver, String screenshotName) {
        logs.debug("Taking screenshohts");

        var screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        var path = String.format("%s/%s.png", screenShotPath, screenshotName);

        try {
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (IOException ioException) {
            logs.error("Path no existe");
            logs.error(ioException.getLocalizedMessage());
        }
    }

    @Attachment(value = "Screenshot Failure", type = "image/png")
    public byte[] attachAllureScreenShot(WebDriver driver) {
        logs.debug("Attaching screenshot to allure");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void deleteScreenShotDirectory() {
        try {
            logs.debug("Cleaning screenShot Directory");
            FileUtils.deleteDirectory(new File(screenShotPath));
        } catch (IOException ioException) {
            logs.error("El path no existe");
            logs.error(ioException.getLocalizedMessage());
        }
    }

    @Attachment(value = "Screenshot failure", type = " image/png")
    public static byte[] getAllureScreenShot() {
        return ((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.BYTES);
    }
}
