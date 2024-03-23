import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;


public class Alerts extends BaseTest {

    @Test
    public void alerts() {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        Alert alert = driver.switchTo().alert();

        String inputText = "Test text";
        alert.sendKeys(inputText);
        alert.accept();

        WebElement enteredText = driver.findElement(By.id("result"));
        String displayedText = enteredText.getText();

        Assert.assertTrue(displayedText.contains(inputText));
    }
}
