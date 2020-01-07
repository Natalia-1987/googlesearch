import common.model.HotlineItem;
import helper.PropertiesHelper;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.unitils.reflectionassert.ReflectionAssert;
import pageobject.HotlinePage;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


public class HotlineTests extends BaseTest {

    private Logger logger = Logger.getLogger(HotlineTests.class);

    @Test
    public void verifyHotlineAscendingSortingTest() throws IOException {

        logger.info("Start 'Verify Hotline Ascending Test'");

        PropertiesHelper propertiesHelper = new PropertiesHelper();

        WebDriver webDriver = getWebDriver();

        logger.info("Init 'Webdriver'");

        String url = "https://hotline.ua/mobile/chehly-sumki-futlyary-dlya-mobilnyh-i-smartfonov/71061-380639/";

        webDriver.get(url);

        logger.info(String.format("Opened following url '%s'", url));

        HotlinePage hotlinePage = new HotlinePage(webDriver);

        List<HotlineItem> unsortedHotlineItemsList = hotlinePage.getHotlineProducts();

        Collections.sort(unsortedHotlineItemsList); // 1 - 2

//        unsortedHotlineItemsList.sort(Collections.reverseOrder()); // 2 - 1

        hotlinePage.orderBy("возрастанию цены");

        List<HotlineItem> sortedHotlineItemsList = hotlinePage.getHotlineItemsUsingStreamApi();

        ReflectionAssert.assertReflectionEquals("There is incorrect sorting found",
                unsortedHotlineItemsList, sortedHotlineItemsList);
    }

    @Test
    public void checkFirstItemsAreSortedInAscendingOrder (){

        WebDriver webDriver = getWebDriver();
        String url = "https://hotline.ua/mobile/chehly-sumki-futlyary-dlya-mobilnyh-i-smartfonov/71061-380639/";
        webDriver.get(url);
        HotlinePage hotlinePage = new HotlinePage(webDriver);

        hotlinePage.orderBy("возрастанию цены");

        List<HotlineItem> sortedHotlineItemsList = hotlinePage.getHotlineItemsUsingStreamApi();

        HotlineItem firstExpected = sortedHotlineItemsList.get(0);

        HotlineItem firstActual = new HotlineItem("URBAN ARMOR GEAR iPhone 6/iPhone 6s/iPhone 7 Metropolis Folio Blue...", 755);


        Assert.assertEquals("There is incorrect title displayed", firstExpected.getTitle(), firstActual.getTitle());
        Assert.assertEquals("There is incorrect title displayed", firstExpected.getPrice(), firstActual.getPrice());
    }
}

