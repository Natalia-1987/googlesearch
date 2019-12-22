package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.panels.BookingCalendarPanel;

import java.util.List;

public class BookingMainPage extends AbstractPage{

    @FindBy(xpath = "//input[@id='ss']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@data-placeholder='Check-in']")
    private WebElement openCalendarButton;

//
    @FindBy (xpath = "//button[contains(@class, 'sb-searchbox__button')]")
    private WebElement searchButton;

    private List<WebElement> predictiveSearchList;


    public BookingMainPage(WebDriver webDriver){
        super(webDriver);
    }

    public BookingResultsPage performSearch(){
        searchButton.click();
        return new BookingResultsPage(getWebDriver());
    }

    public void typeTravelPlace(String destination){
        searchInput.sendKeys(destination);
        getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(predictiveSearchList));
        predictiveSearchList.get(0).click();
    };

    public BookingCalendarPanel openTravelingCalendar(){
        //openCalendarButton.click();
        return new BookingCalendarPanel(getWebDriver());
    }
}
