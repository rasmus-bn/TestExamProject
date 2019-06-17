package dk.projectsbygroup7.testproject.acceptancetests;

import dk.projectsbygroup7.testproject.uiautomationapi.AutomationSetup;
import dk.projectsbygroup7.testproject.uiautomationapi.CourseProgram;
import dk.projectsbygroup7.testproject.uiautomationapi.Home;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class FirstTry {

    WebDriver webDriver;

    @Test
    public void doSelenium() {
        webDriver = AutomationSetup.getChromeDriver();
        Home home = new Home(webDriver).loadHome();
        CourseProgram courseProgram = home.goToCourseProgram(null);
    }
}
