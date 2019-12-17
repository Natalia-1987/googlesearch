package pageobject.panels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.AbstractPage;

public class BookingCalendarPanel extends AbstractPage {

    @FindBy(xpath = "//div[@data-bui-ref='calendar-next']")
    private WebElement nextMonthButton;

    @FindBy(xpath = "//div[@class='bui-calendar__wrapper'])[1]")
    private WebElement calendarMonth;

    public void  selectTravelDate(String travelDate){//format: 12 лютий 2020

        Boolean isMonthFound = true;

        while (isMonthFound){

        }
    }
}
