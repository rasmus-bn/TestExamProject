package dk.projectsbygroup7.testproject.acceptancetests;

import dk.projectsbygroup7.testproject.uiautomationapi.AutomationSetup;
import dk.projectsbygroup7.testproject.uiautomationapi.CourseDetails;
import dk.projectsbygroup7.testproject.uiautomationapi.CourseProgram;
import dk.projectsbygroup7.testproject.uiautomationapi.Home;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class StudentEnrollment {

    private WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = AutomationSetup.getChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        //webDriver.quit();
    }

    @Test
    public void testEnrollment() {
        Home home = new Home(webDriver).loadHome();
        CourseProgram program = home.goToCourseProgram(null);
        CourseDetails courseDetails = program.chooseFromCourseListAtNumber(1, null);
        courseDetails.fillName("bob");
        courseDetails.fillBirthday("06/29/1980");
        courseDetails.fillEmail("bob@df.dd");
        courseDetails.fillCardNumber("123334567898776");
        courseDetails.fillExpMonth("11");
        courseDetails.fillExpYear("1980");
        courseDetails.fillCvv("111");
        courseDetails.clickRegisterEnrollment();
    }
}
