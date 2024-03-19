package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectPage;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys("atrostyanko@gmail.com");
        loginPage.getPasswordInput().sendKeys(ReadProperties.password());
        loginPage.clickLoginButton();

        Thread.sleep(4000);
    }

    @Test
    public void successfulLoginTest1() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProjectPage projectPage = new ProjectPage(driver);
    }
}