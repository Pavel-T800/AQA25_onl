import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaminateCalcTest {
    private WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {
        driver = new BrowserService().getDriver();
    }

    @Test
    public void validateLaminate() throws InterruptedException {
        driver.get("https://home-ex.ru/calculation/ ");
        Thread.sleep(2000);

        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.clear();
        roomLength.sendKeys("550");

        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.clear();
        roomWidth.sendKeys("300");

        WebElement dieLength = driver.findElement(By.id("ln_lam_id"));
        dieLength.clear();
        dieLength.sendKeys("1200");

        WebElement dieWidth = driver.findElement(By.id("wd_lam_id"));
        dieWidth.clear();
        dieWidth.sendKeys("300");

        WebElement amountOfDiesPerPackage = driver.findElement(By.id("n_packing"));
        amountOfDiesPerPackage.clear();
        amountOfDiesPerPackage.sendKeys("10");

        WebElement packingArea = driver.findElement(By.id("area"));
        packingArea.clear();
        packingArea.sendKeys("30");

        //0 -  Укладка по длине 0°, 1 - Укладка по ширине 90°, 2 - Укладка по диагонали 45°, 3 - Укладка по диагонали 135°
        WebElement laminateLayingDirection = driver.findElement(By.id("direction-laminate-id2"));
        laminateLayingDirection.click();

        WebElement methodForLayingLaminate = driver.findElement(By.id("laying_method_laminate"));
        Select methodForLayingLaminateDropdown = new Select(methodForLayingLaminate);
        //0 - со смещением на 1/3 длины, 1 - со смещением на 1/2 длины, 2 - с использованием отрезанного элемента
        methodForLayingLaminateDropdown.selectByIndex(2);

        WebElement calculateButton = driver.findElement(By.id("btn_calculate"));
        calculateButton.click();

        WebElement calculatePlankAmount = driver.findElement(By.xpath("//*[contains(text(), 'Требуемое количество плашек ламината')]"));
        WebElement calculatePackAmount = driver.findElement(By.xpath("//*[contains(text(), 'Количество упаковок ламината')]"));
        Assert.assertEquals(calculatePlankAmount.getText(), "Требуемое количество плашек ламината: 52");
        Assert.assertEquals(calculatePackAmount.getText(), "Количество упаковок ламината: 6");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void browserQuit() {
        driver.quit();
    }
}