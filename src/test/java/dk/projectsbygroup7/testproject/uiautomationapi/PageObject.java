package dk.projectsbygroup7.testproject.uiautomationapi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

abstract class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    protected void fillInputValue(String cssSelector, String input) {
        driver.findElement(By.cssSelector(cssSelector)).sendKeys(input);
    }
}
