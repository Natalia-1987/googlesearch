package pageobject;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class BookingResultsPage extends AbstractPage{

    @FindBys({
            @FindBy(xpath = "//a[@class='bui-link']")
    })
    private List<WebElement> searchResults;

    public BookingResultsPage(WebDriver webDriver){
        super(webDriver);
    }

    public String getFirstAvailableHotelDestination(){
        return StringUtils.trim(searchResults.get(0).getText());
    }

}
