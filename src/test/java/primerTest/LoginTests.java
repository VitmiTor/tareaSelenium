package primerTest;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTests extends BaseTest {

    @Test(groups = {smoke, regression})
    public void login() {
        var linkLoginPage = driver.findElement(By.linkText("Form Authentication"));
        linkLoginPage.click();
        utilities.waitSeconds(2);
        var usernameInput = driver.findElement(By.id("username"));
        var passwordInput = driver.findElement(By.id("password"));
        var buttonInput = driver.findElement(By.className("radius"));

        Assert.assertTrue(usernameInput.isDisplayed());
        usernameInput.sendKeys("tomsmith");
        Assert.assertTrue(passwordInput.isDisplayed());
        passwordInput.sendKeys("SuperSecretPassword!");
        Assert.assertTrue(buttonInput.isDisplayed());
        buttonInput.click();
        utilities.waitSeconds(2);

        var greenframeVisible = driver.findElement(By.id("flash"));
        var logoutInput = driver.findElement(By.cssSelector("i[class='icon-2x icon-signout']"));

        logs.info("verificando el cuadro verde");
        Assert.assertTrue(greenframeVisible.isDisplayed());
        logs.info("verificando el botón este visible");
        Assert.assertTrue(logoutInput.isDisplayed());
        logs.info("Haciendo logout click");
        logoutInput.click();

        usernameInput = driver.findElement(By.id("username"));
        Assert.assertTrue(usernameInput.isDisplayed());

        logs.info("Realizando el test Regression -> test 2");

        usernameInput = driver.findElement(By.id("username"));
        Assert.assertTrue(usernameInput.isDisplayed());
        passwordInput = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordInput.isDisplayed());
        buttonInput = driver.findElement(By.className("radius"));
        usernameInput.sendKeys("hola123");
        passwordInput.sendKeys("heheheeh");
        buttonInput.click();
        utilities.waitSeconds(2);
        var redframeInput = driver.findElement(By.id("flash"));
        Assert.assertTrue(redframeInput.isDisplayed());
    }

    @Test(groups = {regression})
    public void exercise3() {
        logs.info("Realizando ejercicio 3");
        var checkBoxesPage = driver.findElement(By.linkText("Checkboxes"));
        checkBoxesPage.click();
        utilities.waitSeconds(2);
        var checkboxList = driver.findElements(By.cssSelector("input[type='checkbox']"));

        var firstCheckBox = checkboxList.get(0);
        var secondCheckBox = checkboxList.get(1);

        Assert.assertFalse(firstCheckBox.isSelected());
        Assert.assertTrue(secondCheckBox.isSelected());
        firstCheckBox.click();
        secondCheckBox.click();

        utilities.waitSeconds(3);
        Assert.assertTrue(firstCheckBox.isSelected());
        Assert.assertFalse(secondCheckBox.isSelected());
    }

    @Test(groups = {regression})
    public void exercise4() {
        logs.info("Realizando ejercicio 4");
        var addElementsPage = driver.findElement(By.linkText("Add/Remove Elements"));
        addElementsPage.click();
        utilities.waitSeconds(2);
        var buttonAddInput = driver.findElement(By.xpath("//button[text()='Add Element']"));
        for (var i = 0; i < 10; i++) {
            buttonAddInput.click();
        }
        utilities.waitSeconds(5);
        var buttonDeletes = driver.findElements(By.className("added-manually"));
        List<WebElement> buttonDeleteList = buttonDeletes;
        Assert.assertEquals(buttonDeleteList.size(), 10);
        for (var i = 0; i < 10; i++) {
            buttonDeleteList.get(i).click();
        }
        buttonDeletes = driver.findElements(By.className("added-manually"));
        buttonDeleteList = buttonDeletes;
        Assert.assertEquals(buttonDeleteList.size(), 0);
    }

    @Test(groups = {smoke, regression})
    public void exercise5() {
        logs.info("Realizando el ejercicio 5");
        var statusPage = driver.findElement(By.linkText("Status Codes"));
        statusPage.click();
        utilities.waitSeconds(2);
        var link404 = driver.findElement(By.linkText("404"));
        utilities.waitSeconds(2);
        var linkHere = driver.findElement(By.linkText("here"));
        utilities.waitSeconds(2);

        Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/status_codes");
    }
}
