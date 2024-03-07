import configuration.ReadProperties;
import core.AdvancedDriver;
import core.BrowserService;
import core.SimpleDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void simpleDriverTest() {
        SimpleDriver simpleDriver = new SimpleDriver();
        WebDriver driver = simpleDriver.getDriver();
        driver.get(ReadProperties.getUrl());
        //Thread.sleep(2000);

        driver.quit();
    }

    @Test
    public void advancedDriverTest() {
        AdvancedDriver advancedDriver = new AdvancedDriver();
        WebDriver driver = advancedDriver.getDriver();

        driver.get(ReadProperties.getUrl());

        driver.quit();
    }

    @Test
    public void browsersServiceTest() {
        BrowserService browsersService = new BrowserService();
        WebDriver driver = browsersService.getDriver();

        driver.get(ReadProperties.getUrl());

        driver.quit();
    }
}
