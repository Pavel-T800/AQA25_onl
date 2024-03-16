package _otherPackages.steps;

import _otherPackages.baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import _otherPackages.pages.ProjectsPage;

public class NavigationStep extends BaseStep {

    public NavigationStep(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage navigateToProjectsPage() {
        projectsPage.openPageByUrl();
        return projectsPage;
    }
}
