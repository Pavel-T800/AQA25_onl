import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControls extends BaseTest {

    @Test
    public void dynamicControls() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement checkbox = waitsService.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"checkbox\"]/input"));
        Assert.assertTrue(checkbox.isDisplayed());

        //Нажать на кнопку Remove около чекбокса
        WebElement removeButton = waitsService.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"checkbox-example\"]/button"));
        removeButton.click();

        //Дождаться надписи “It’s gone”
        WebElement loadingForAddRemove = waitsService.waitForVisibilityLocatedBy(By.id("loading"));
        Assert.assertTrue(loadingForAddRemove.isDisplayed());
        Assert.assertEquals(waitsService.waitForVisibilityLocatedBy(By.id("loading")).getText(), "Wait for it...");
        Assert.assertEquals(waitsService.waitForVisibilityLocatedBy(By.id("message")).getText(), "It\'s gone!");

        //Проверить, что чекбокса нет
        boolean checkboxInvisible = driver.findElements(By.xpath("//*[@id=\"checkbox\"]/input")).isEmpty();

        //Найти инпут
        // Проверить, что он disabled
        WebElement inputDisabled = waitsService.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"input-example\"]/input"));
        Assert.assertFalse(inputDisabled.isEnabled());

        //Нажать на кнопку
        WebElement enableButton = waitsService.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"input-example\"]/button"));
        enableButton.click();

        // Дождаться исчезновения текста "Wait for it..."
        waitsService.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

        // Убедиться, что текст "It's enabled!" появляется только после исчезновения "Wait for it..."
        WebElement messageElement = waitsService.waitForVisibilityLocatedBy(By.id("message"));
        waitsService.until(ExpectedConditions.invisibilityOfElementWithText(By.id("loading"), "Wait for it..."));
        Assert.assertEquals(messageElement.getText(), "It's enabled!");

        // Проверить, что элемент `<input>` доступен после появления текста "It's enabled!"
        WebElement inputEnabled = waitsService.waitForVisibilityLocatedBy(By.xpath("//*[@id=\"input-example\"]/input"));
        Assert.assertTrue(inputEnabled.isEnabled(), "Элемент не доступен после появления текста \"It's enabled!\"");
    }
}