package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class WaitsTest extends BaseTest {

    @Test
    public void presenceOfElementTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Assert.assertFalse(button.isDisplayed());

        WebElement loading = driver.findElement(By.id("loading"));
        Assert.assertTrue(loading.isDisplayed());
        Assert.assertFalse(loading.isDisplayed());

        Assert.assertTrue(driver.findElement(By.id("finish")).isDisplayed());
    }

    @Test
    public void presenceOfElementTest1() {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement button = wait.waitForVisibilityLocatedBy(By.tagName("button"));
        button.click();
        Assert.assertTrue(wait.waitForElementInvisible(button));

        WebElement loading = wait.waitForVisibilityLocatedBy(By.id("loading"));
        Assert.assertTrue(loading.isDisplayed());
        Assert.assertTrue(wait.waitForElementInvisible(loading));

        Assert.assertTrue(wait.waitForVisibilityLocatedBy(By.id("finish")).isDisplayed());
    }
}
