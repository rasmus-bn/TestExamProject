package dk.projectsbygroup7.testproject.uiautomationapi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationSetup {

    private static final String homeLink = "http://localhost:8080/";

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/ras/Downloads/webdrivers/chromedriver");
        return new ChromeDriver();
    }

    public static String getHomeLink() {
        return homeLink;
    }
}
