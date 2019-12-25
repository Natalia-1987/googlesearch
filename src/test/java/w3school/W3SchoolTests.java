package w3school;

import common.BaseTest;
import common.PropertiesHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pageobject.w3school.W3SchoolMainPage;

public class W3SchoolTests extends BaseTest {


    @Test
    public void verifyPressedButtonColorInFrameTest (){

        PropertiesHelper propertiesHelper = new PropertiesHelper();

        String w3SchoolsUrl = propertiesHelper.readProperty("w3schools.main.url");

        webDriver.get(w3SchoolsUrl);

        W3SchoolMainPage w3SchoolMainPage = new W3SchoolMainPage(webDriver);

        w3SchoolMainPage.clickCssButton();

        String actualColor = w3SchoolMainPage.getCssMenuButtonItemPresentColor();

        String expectedColor =  "rgba(76, 175, 80, 1)";

        Assert.assertEquals("There is incorrect selected menu item color", expectedColor, actualColor);

    }

    @After
    public void shutDownDriver(){
        webDriver.close();
        webDriver.quit();
    }



}
