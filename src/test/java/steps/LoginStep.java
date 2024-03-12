package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public DashboardPage successLogin(String email, String psw) {
        login(email, psw);

        return dashboardPage;
    }

    public LoginPage incorrectLogin(String email, String psw) {
        login(email, psw);

        return loginPage;
    }

    private void login(String email, String psw) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPswInput().sendKeys(psw);
        loginPage.getLogInButton().click();
    }

    public LoginPage logout() {

        return loginPage;
    }
}
