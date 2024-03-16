import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;


public class ContextMenu extends BaseTest {

    @Test
    public void contextMenu() {
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement rightClick = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions.contextClick(rightClick).perform();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "You selected a context menu");
        alert.accept();
    }
}