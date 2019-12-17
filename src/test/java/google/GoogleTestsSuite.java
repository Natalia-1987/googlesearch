package google;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pageobject.google.GoogleSearchPage;
import pageobject.google.GoogleSearchResultsPage;
import pageobject.rozetka.RozetkaMainPage;

import java.util.List;

public class GoogleTestsSuite extends BaseTest {


//    @Test
//    public void checkGoogleSiteTitle(){
//        webDriver.get("https://www.google.com/");
//        String title = webDriver.getTitle();
//        Assert.assertEquals("There is incorrect title displayed!", title);
//    }

    @Test
    public void verifyGooglePredictiveSearchFunctionality() {

        String googleUrl = propertyHelper.readProperty("site.url");

        webDriver.get(googleUrl);

        GoogleSearchPage searchPage = new GoogleSearchPage(webDriver);

        searchPage.searchFor("rozetka");

        List<String> predictiveSearchList = searchPage.getPredictiveSearchListText();
        Assert.assertFalse("There are no item found!", predictiveSearchList.isEmpty());

        predictiveSearchList.forEach(item -> {
            Assert.assertTrue("There is no such item present!", item.contains("rozetka"));
        });
    }

    @Test
    public void verifyGoogleSearch(){
        String googleUrl = propertyHelper.readProperty("site.url");

        webDriver.get(googleUrl);

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(webDriver);

        GoogleSearchResultsPage resultsPage = googleSearchPage.searchForWithEnter("rozetka");

        String navUrl = resultsPage.getFirstUrl();

        webDriver.get(navUrl);

        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(webDriver);

        Assert.assertEquals("There is incorrect title present, opened via first URL",
                "Интернет магазин Rozetka.ua - №1", rozetkaMainPage.getHeaderLogoTitle());
    }
}
