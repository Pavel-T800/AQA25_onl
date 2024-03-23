import core.WaitsService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitsTest extends BaseTest {

    @Test
    public void presenceOfElementTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Assert.assertFalse(button.isDisplayed());

        WebElement loading = driver.findElement(By.id("loading"));
        Assert.assertTrue(loading.isDisplayed());
        Thread.sleep(10000);
        Assert.assertFalse(loading.isDisplayed());

        Assert.assertEquals(driver.findElement(By.id("finish")).getText(), "Hello World!");
    }

    @Test
    public void presenceOfElementTest1() {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement button = waitsService.waitForElementClickable(By.tagName("button"));
        button.click();
        Assert.assertTrue(waitsService.waitForElementInvisible(button));

        WebElement loading = waitsService.waitForVisibilityLocatedBy(By.id("loading"));
        Assert.assertTrue(loading.isDisplayed());
        Assert.assertTrue(waitsService.waitForElementInvisible(loading));

        Assert.assertEquals(waitsService.waitForVisibilityLocatedBy(By.id("finish")).getText(), "Hello World!");
    }
}