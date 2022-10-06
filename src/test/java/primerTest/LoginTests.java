package primerTest;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(groups = {smoke, regression})
    public void login() {
        var linkLoginPage = driver.findElement(By.linkText("Form Authentication"));
        logs.info("ingresando al path de login page");
        linkLoginPage.click();
        utilities.waitSeconds(2);
        var usernameInput = driver.findElement(By.id("username"));
        var passwordInput = driver.findElement(By.id("password"));
        var buttonInput = driver.findElement(By.className("radius"));

        logs.info("verificando que este visible username");
        Assert.assertTrue(usernameInput.isDisplayed());
        logs.info("ingresando el username");
        usernameInput.sendKeys("tomsmith");
        logs.info("verificando que el password este visible");
        Assert.assertTrue(passwordInput.isDisplayed());
        logs.info("ingresando la contrasenia");
        passwordInput.sendKeys("SuperSecretPassword!");
        logs.info("verificando que el boton este visible");
        Assert.assertTrue(buttonInput.isDisplayed());
        logs.info("clcik en el boton login");
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
        logs.info("verificando que username este visible");
        Assert.assertTrue(usernameInput.isDisplayed());

        usernameInput = driver.findElement(By.id("username"));
        logs.info("verificando que username este visible");
        Assert.assertTrue(usernameInput.isDisplayed());
        passwordInput = driver.findElement(By.id("password"));
        logs.info("verificando que password este visible");
        Assert.assertTrue(passwordInput.isDisplayed());
        buttonInput = driver.findElement(By.className("radius"));
        logs.info("ingresando el admin erroneo");
        usernameInput.sendKeys("hola123");
        logs.info("ingresando la contrasenia erronea");
        passwordInput.sendKeys("heheheeh");
        buttonInput.click();
        utilities.waitSeconds(2);
        var redframeInput = driver.findElement(By.id("flash"));
        logs.info("verificando que el cuadro rojo sea visible");
        Assert.assertTrue(redframeInput.isDisplayed());
    }

    @Test(groups = {regression})
    public void exercise3() {
        logs.info("Realizando ejercicio 3");
        var checkBoxesPage = driver.findElement(By.linkText("Checkboxes"));
        logs.info("ingresnado al Page de checkBoxes");
        checkBoxesPage.click();
        utilities.waitSeconds(2);
        var checkboxList = driver.findElements(By.cssSelector("input[type='checkbox']"));

        var firstCheckBox = checkboxList.get(0);
        var secondCheckBox = checkboxList.get(1);

        logs.info("verificando que el primer check NO este seleccionado");
        Assert.assertFalse(firstCheckBox.isSelected());
        logs.info("verificando que el segundo check este seleccionado");
        Assert.assertTrue(secondCheckBox.isSelected());
        firstCheckBox.click();
        secondCheckBox.click();

        utilities.waitSeconds(3);
        logs.info("verificando que el primer check este seleccionado");
        Assert.assertTrue(firstCheckBox.isSelected());
        logs.info("verificando que el segundo check NO este seleccionado");
        Assert.assertFalse(secondCheckBox.isSelected());
    }

    @Test(groups = {regression})
    public void exercise4() {
        logs.info("Realizando ejercicio 4");
        var addElementsPage = driver.findElement(By.linkText("Add/Remove Elements"));
        logs.info("ingresnado al addPage");
        addElementsPage.click();
        utilities.waitSeconds(2);
        var buttonAddInput = driver.findElement(By.xpath("//button[text()='Add Element']"));
        for (var i = 0; i < 10; i++) {
            buttonAddInput.click();
        }
        utilities.waitSeconds(5);
        var buttonDeleteList = driver.findElements(By.className("added-manually"));
        logs.info("verificando que el listado sea de tamanio 10");
        Assert.assertEquals(buttonDeleteList.size(), 10);
        logs.info("Realizar click en todos los buttons delete");
        for (var i = 0; i < 10; i++) {
            buttonDeleteList.get(i).click();
        }
        buttonDeleteList = driver.findElements(By.className("added-manually"));
        logs.info("verificando que el listado sea de tamanio 0");
        Assert.assertEquals(buttonDeleteList.size(), 0);
    }

    @Test(groups = {smoke, regression})
    public void exercise5() {
        logs.info("Realizando el ejercicio 5");
        var statusPage = driver.findElement(By.linkText("Status Codes"));
        statusPage.click();
        utilities.waitSeconds(2);
        logs.info("Click en el 404");
        var link404 = driver.findElement(By.linkText("404"));
        utilities.waitSeconds(2);
        logs.info("Click en el here");
        var linkHere = driver.findElement(By.linkText("here"));
        utilities.waitSeconds(2);
        logs.info("verificando la url sea el mismo");
        Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/status_codes");
    }
}
