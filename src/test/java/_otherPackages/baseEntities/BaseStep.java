package _otherPackages.baseEntities;

import org.openqa.selenium.WebDriver;
import _otherPackages.pages.DashboardPage;
import _otherPackages.pages.LoginPage;
import _otherPackages.pages.ProjectsPage;

public class BaseStep {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ProjectsPage projectsPage;


    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        projectsPage = new ProjectsPage(driver);
    }
}
