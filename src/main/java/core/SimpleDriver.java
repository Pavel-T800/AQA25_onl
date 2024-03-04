package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/pavelsaz/Documents/JAVA/AQANewProject/AQA25_onl/src/test/resources/chromedriver");

        return new ChromeDriver();
    }
}
