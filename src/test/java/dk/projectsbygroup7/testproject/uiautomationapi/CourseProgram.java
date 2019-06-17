package dk.projectsbygroup7.testproject.uiautomationapi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CourseProgram extends PageObject {
    public CourseProgram(WebDriver driver) {
        super(driver);
    }

    public CourseDetails chooseFromCourseListAtNumber(int number, CourseDetails courseDetails) {
        List<WebElement> courses = driver.findElements(By.className("course-item"));
        courses.get(number - 1).click();
        if (courseDetails == null) return new CourseDetails(driver);
        return courseDetails;
    }
}
