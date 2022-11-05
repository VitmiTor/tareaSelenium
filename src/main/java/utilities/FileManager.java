package utilities;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;

public class FileManager {
    private final Logs logs = new Logs();
    public static WebDriver staticDriver;
    private final String screenShotPath = "src/test/resources/screenshots";

    public FileManager redirectStdErr() {
        logs.debug("Redirecting stderr");
        var file = new File("src/test/resources/logs/stderr.log");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        PrintStream ps = new PrintStream(fos);
        System.setErr(ps);
        return this;
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


    public void deleteScreenShotDirectory() {
        try {
            logs.debug("Cleaning screenShot Directory");
            FileUtils.deleteDirectory(new File(screenShotPath));
        } catch (IOException ioException) {
            logs.error("El path no existe");
            logs.error(ioException.getLocalizedMessage());
        }
    }

    @Attachment(value = "Screenshot failure", type = "image/png")
    public static byte[] getAllureScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
