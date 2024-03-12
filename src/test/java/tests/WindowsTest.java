package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsTest extends BaseTest {

    @Test
    public void newTabTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/windows");


        driver.findElement(By.linkText("Click Here")).click();

        String originalWindow = driver.getWindowHandle();

        Set<String> windowHandlesSet = driver.getWindowHandles();
        List<String> windowHandleList = new ArrayList<>(windowHandlesSet);

        driver.switchTo().window(windowHandleList.get(1));

        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "New Window");

    }
}
