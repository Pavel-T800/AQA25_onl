import core.SimpleDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void simpleDriverTest() {
        SimpleDriver simpleDriver = new SimpleDriver();
        WebDriver driver = simpleDriver.getDriver();
    }
}
