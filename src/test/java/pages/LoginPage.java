package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // Блок описания локаторов для элементов
    private final By emailInputLocator = By.id("name");
    private final By passwordInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("button_primary");

    // Блок иницализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Блок атомарных методов
    public WebElement getEmailInput() {
        return driver.findElement(emailInputLocator);
    }

    public WebElement getPasswordInput() {
        return driver.findElement(passwordInputLocator);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButtonLocator);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }
}