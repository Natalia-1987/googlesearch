package common;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    protected WebDriver webDriver;
    protected PropertiesHelper propertyHelper = new PropertiesHelper();


    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        webDriver = new ChromeDriver();
    }

    @After
    public void shutDownDriver() {
        webDriver.close();
        webDriver.quit();
    }
}