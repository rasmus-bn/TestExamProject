package dk.projectsbygroup7.testproject.uiautomationapi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends PageObject {
    public Home(WebDriver driver) {
        super(driver);
    }

    public Home loadHome(){
        System.out.println(AutomationSetup.getHomeLink());
        driver.navigate().to(AutomationSetup.getHomeLink());
        return this;
    }

    public CourseProgram goToCourseProgram(CourseProgram courseProgram){
        driver.findElement(By.id("courseProgramLink")).click();
        if (courseProgram == null) return new CourseProgram(driver);
        return courseProgram;
    }

    public EditCourses goToEditCourses(EditCourses editCourses){
        driver.findElement(By.id("editCoursesLink")).click();
        if (editCourses == null) return new EditCourses(driver);
        return editCourses;
    }
}
