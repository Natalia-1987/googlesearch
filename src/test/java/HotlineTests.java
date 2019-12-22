import common.model.HotlineItem;
import helper.PropertiesHelper;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.unitils.reflectionassert.ReflectionAssert;
import pageobject.HotlinePage;

import java.io.IOException;
import java.util.List;

public class HotlineTests extends BaseTest {

    @Test
    public void verifyHotlineAscendingSortingTest() throws IOException {
        PropertiesHelper propertiesHelper = new PropertiesHelper();

        WebDriver webDriver = getWebDriver();

        String url = "https://hotline.ua/mobile/chehly-sumki-futlyary-dlya-mobilnyh-i-smartfonov/71061-380639/";

        webDriver.get(url);

        HotlinePage hotlinePage = new HotlinePage(webDriver);

        List<HotlineItem> unsortedHotlineItemsList = hotlinePage.getHotlineProducts();

        //unsortedHotlineItemsList.sort(Collections.reverseOrder());

        hotlinePage.orderBy("зростанням цiни");

        List<HotlineItem> sortedHotlineItemsList = hotlinePage.getHotlineItemsUsingStreamApi();

        ReflectionAssert.assertReflectionEquals("There is incorrect sorting found",
                unsortedHotlineItemsList, sortedHotlineItemsList);
    }
}

