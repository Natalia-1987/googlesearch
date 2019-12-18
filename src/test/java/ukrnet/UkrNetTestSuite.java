package ukrnet;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pageobject.ukrnet.UkrNetArticleDetailsPage;
import pageobject.ukrnet.UkrNetMainPage;

public class UkrNetTestSuite extends BaseTest {

    @Test
    public void verifyUserIsAbleToNavigateToFirstArticleByClick(){
        String navUrl = propertyHelper.readProperty("ukrnet.main.page.url");
        webDriver.get(navUrl);

        UkrNetMainPage ukrNetMainPage = new UkrNetMainPage(webDriver);

        String expectedArticleText = ukrNetMainPage.getFirstArticleText();

        UkrNetArticleDetailsPage ukrNetArticleDetailsPage = ukrNetMainPage.selectFirstArticle();

        String actualArticleText = ukrNetArticleDetailsPage.getarticleHeadText();

        Assert.assertEquals("There is incorrect article text displayed!", expectedArticleText, actualArticleText);
    }
}
