package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage {
    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Projects')]");

    // Блок иницализации
    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    // Блок атомарных методов
    public WebElement getHeaderTitleLabel() {
        return driver.findElement(headerTitleLabelLocator);
    }
}