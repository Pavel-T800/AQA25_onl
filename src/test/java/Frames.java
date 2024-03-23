import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Frames extends BaseTest {

    @Test
    public void frame() {

        driver.get("https://the-internet.herokuapp.com/frames");

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/a")).click();

        driver.switchTo().frame(0);

        Assert.assertTrue(driver.findElement(By.id("tinymce")).isDisplayed());

        driver.switchTo().parentFrame();

        Assert.assertTrue(driver.findElement(By.className("tox-editor-container")).isDisplayed());
    }
}
