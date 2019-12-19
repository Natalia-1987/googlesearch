import helper.PropertiesHelper;
import org.junit.Assert;
import org.junit.Test;
import pageobject.BookingMainPage;
import pageobject.BookingResultsPage;
import pageobject.panels.BookingCalendarPanel;

import java.io.IOException;

public class BookingTests extends BaseTest{

    private PropertiesHelper propertiesHelper;

    public BookingTests() throws IOException {
        propertiesHelper = new PropertiesHelper();
    }

    @Test
    public void verifySearchWorksAsExpectedTest(){

        String navigationUrl = propertiesHelper.readProperty("booking.main.page.url");

        getWebDriver().get(navigationUrl);

        BookingMainPage bookingMainPage = new BookingMainPage(getWebDriver());

        bookingMainPage.typeTravelPlace("Milan");
        BookingCalendarPanel calendar = bookingMainPage.openTravelingCalendar();
        calendar.selectTravelDate("20", "March 2020");

        BookingResultsPage bookingResultsPage = bookingMainPage.performSearch();

        String firstHotel = bookingResultsPage.getFirstAvailableHotelDestination();

        Assert.assertEquals("There is incorrect first destination displayed!",
                "Milan", firstHotel);
    }
}
