package pageobject.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

import java.util.List;

public class GoogleSearchResultsPage extends AbstractPage {

    @FindBys({
            @FindBy(xpath = "//div[@class='r']//span[@class='S3Uucc']/../..")
    })
    private List<WebElement> navigationUrls;

    public GoogleSearchResultsPage(WebDriver webDriver){
        super(webDriver);
    }

    public String getFirstUrl(){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(navigationUrls));
        return navigationUrls.get(0).getAttribute("href");
    }
}


