import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ByMedCalcTest {
    private WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {
        driver = new BrowserService().getDriver();
    }

    @Test
    public void validateSKF() throws InterruptedException {
        driver.get("https://bymed.top/calc/%D1%81%D0%BA%D1%84-2148");
        Thread.sleep(10000); //

        //WebElement consentButton =  driver.findElement(By.xpath("//button[text()='Consent']"));

        driver.switchTo().frame(1);
        WebElement ageField = driver.findElement(By.id("age"));
        ageField.sendKeys("31");

        WebElement sexField = driver.findElement(By.id("sex"));
        Select sexDropdown = new Select(sexField);
        sexDropdown.selectByIndex(0); // 0 - Мужской, 1 - Женский

        WebElement creatinineField = driver.findElement(By.id("cr"));
        creatinineField.sendKeys("0.085");
        WebElement crSizeField = driver.findElement(By.id("cr-size"));
        Select crSizeDropdown = new Select(crSizeField);
        crSizeDropdown.selectByIndex(1); // 0 - мкмоль/л, 1 - ммоль/л, 2 - мг/дл

        WebElement raceField = driver.findElement(By.id("race"));
        Select raceDropdown = new Select(raceField);
        raceDropdown.selectByIndex(0); // 0 - Другая, 1 - Негроидная


        WebElement weightField = driver.findElement(By.id("mass"));
        weightField.sendKeys("73");

        WebElement heightField = driver.findElement(By.id("grow"));
        heightField.sendKeys("178");

        WebElement calculateButton = driver.findElement(By.xpath("//button[text()='Рассчитать']"));
        calculateButton.click();

        WebElement mdrdResult = driver.findElement(By.id("mdrd"));
        WebElement ckdepiResult = driver.findElement(By.id("ckd_epi"));
        WebElement cgeResult = driver.findElement(By.id("cge"));
        Thread.sleep(2000);

        Assert.assertEquals(mdrdResult.getText().trim(), "91.19 мл/мин/1.73м2 - Нормальный уровень СКФ (C1)");
        Assert.assertEquals(ckdepiResult.getText().trim(), "104.7 мл/мин/1.73м2 - Нормальный уровень СКФ (C1)");
        Assert.assertEquals(cgeResult.getText().trim(), "114.94 мл/мин");

    }

    @AfterMethod
    public void browserQuit() {
        driver.quit();
    }
}
