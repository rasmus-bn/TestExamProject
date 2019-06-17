package dk.projectsbygroup7.testproject.uiautomationapi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CourseDetails extends PageObject {

    public CourseDetails(WebDriver driver) {
        super(driver);
    }

    public void fillName(String input) {
        driver.findElement(By.id("name")).sendKeys(input);
    }

    public void fillBirthday(String input) {
        driver.findElement(By.id("birthday")).sendKeys(input);
    }

    public void fillEmail(String input) {
        driver.findElement(By.id("email")).sendKeys(input);
    }

    public void fillCardNumber(String input) {
        driver.findElement(By.id("cardNumber")).sendKeys(input);
    }

    public void fillExpMonth(String input) {
        driver.findElement(By.id("expirationMonth")).sendKeys(input);
    }

    public void fillExpYear(String input) {
        driver.findElement(By.id("expirationYear")).sendKeys(input);
    }

    public void fillCvv(String input) {
        driver.findElement(By.id("cvv")).sendKeys(input);
    }

    public void clickRegisterEnrollment() {
        driver.findElement(By.id("enrollBtn")).click();
    }
}
