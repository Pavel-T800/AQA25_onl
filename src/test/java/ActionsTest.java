import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class ActionsTest extends BaseTest {

    @Test
    public void hoverTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);

        List<WebElement> targetElements = waitsService.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));

        actions
                .moveToElement(targetElements.get(0),
                        targetElements.get(0).getSize().getWidth() / 2,
                        targetElements.get(0).getSize().getHeight() / 2)
                .click(waitsService.waitForExists(By.cssSelector("[href='/users/1']")))
                .build()
                .perform();

        Assert.assertTrue(waitsService.waitForVisibilityLocatedBy(By.xpath("//h1[text() = 'Not Found']")).isDisplayed());
    }

    @Test
    public void checkBoxTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        Actions actions = new Actions(driver);

        List<WebElement> targetElements = waitsService.waitForAllVisibleElementsLocatedBy(By.cssSelector("#checkboxes input"));

        actions
                .click(targetElements.get(0))
                .build()
                .perform();

        Thread.sleep(3000);
        Assert.assertTrue(targetElements.get(0).isSelected());
    }

    @Test
    public void dragAndDropTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        Actions actions = new Actions(driver);

        WebElement source = waitsService.waitForVisibilityLocatedBy(By.id("column-a"));
        WebElement target = waitsService.waitForVisibilityLocatedBy(By.id("column-b"));

        actions
                .moveToElement(source)
                .clickAndHold()
                .moveToElement(target)
                .release()
                .build()
                .perform();

        actions
                .dragAndDrop(source, target)
                .build()
                .perform();

        Thread.sleep(3000);
    }

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement fileUploadElement = waitsService.waitForExists(By.id("file-upload"));
        String pathToFile = ActionsTest.class.getClassLoader().getResource("data" + File.separator + "download.jpeg").getPath();
        System.out.println(pathToFile);

        fileUploadElement.sendKeys(pathToFile);
        waitsService.waitForExists(By.id("file-submit")).submit();

        Thread.sleep(5000);
    }
}