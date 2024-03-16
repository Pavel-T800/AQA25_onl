import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload extends BaseTest {

    @Test
    public void fileUpload() {

        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement fileUploadElement = waitsService.waitForExists(By.id("file-upload"));
        String pathToFile = ActionsTest.class.getClassLoader().getResource("imagesTest.png").getPath(); //important

        fileUploadElement.sendKeys(pathToFile);
        waitsService.waitForExists(By.id("file-submit")).submit();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());
    }
}
