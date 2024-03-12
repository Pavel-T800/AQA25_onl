package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsOverviewPage extends BasePage {
    public SideMenuPage sideMenuPage;

    private By chartTableLocator = By.id("chart-line-fc");
    private String tabLocator = "//li/a[. = 'Replace']";

    public ProjectsOverviewPage(WebDriver driver) {
        super(driver);

        sideMenuPage = new SideMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return chartTableLocator;
    }

    public WebElement getTabByName(String tabName) {
        return waitsService.waitForExists(By.xpath(tabLocator.replace("Replace", tabName)));
    }
}
