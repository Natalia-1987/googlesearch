package google;

import common.PropertyHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.google.GoogleSearchPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleTestsSuite {

    private WebDriver webDriver;
    private PropertyHelper propertyHelper = new PropertyHelper();

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

    }

//    @Test
//    public void checkGoogleSiteTitle(){
//        webDriver.get("https://www.google.com/");
//        String title = webDriver.getTitle();
//        Assert.assertEquals("There is incorrect title displayed!", title);
//    }

    @Test
    public void verifyGoogleSearchFunctionality() {

        String googleUrl = propertyHelper.readProperty("google.site.url");
        webDriver.get(googleUrl);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        GoogleSearchPage searchPage = new GoogleSearchPage(webDriver);

        searchPage.searchFor("rozetka");

        List<String> predictiveSearchList = searchPage.getPredictiveSearchListText();
        Assert.assertFalse("There are no item found!", predictiveSearchList.isEmpty());

        predictiveSearchList.forEach(item -> {
            Assert.assertTrue("There is no such item present!", item.contains("rozetka"));
        });
    }

    @After
    public void shutDownDriver(){
        webDriver.close();
        webDriver.quit();
    }
}
