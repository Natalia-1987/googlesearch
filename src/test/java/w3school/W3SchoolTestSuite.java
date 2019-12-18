package w3school;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pageobject.w3school.W3SchoolMainPage;

public class W3SchoolTestSuite extends BaseTest {


    @Test
    public void verifySelectedMenuItemColor(){

        String navigationUrl = propertyHelper.readProperty("environment.properties");

        webDriver.get(navigationUrl);

        W3SchoolMainPage w3SchoolMainPage = new W3SchoolMainPage(webDriver);
        w3SchoolMainPage.selectMenuItem();

        String expectedColor =  "#4CAF50";
        String actualColor = w3SchoolMainPage.getSelectedMenuItemColor();

        Assert.assertEquals("There is incorrect selected menu item color", expectedColor, actualColor);

    }



}
