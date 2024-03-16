import core.BrowserService;
import core.WaitsService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.time.Duration;

@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;
    protected WaitsService waitsService;


    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
        waitsService = new WaitsService(driver, Duration.ofSeconds(3));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}