package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.panels.BookingCalendarPanel;

import java.util.List;

public class BookingMainPage extends AbstractPage{

    @FindBy(xpath = "//input[@id='ss']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='sb-date-field__display']")
    private WebElement openCalendarButton;

    @FindBy(xpath = "//div[@class='bui-calendar']")
    private WebElement calendarBlock;

    @FindBy (xpath = "//button[contains(@class, 'sb-searchbox__button')]")
    private WebElement searchButton;

    @FindBys({
            @FindBy(xpath = "//span[@class='search_hl_name']")
    })
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
        String calendarStyle = calendarBlock.getAttribute("style");
        if (calendarStyle.contains("display: none;")) {
            openCalendarButton.click();
        }
        return new BookingCalendarPanel(getWebDriver());
    }
}
