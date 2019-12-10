package pageobject.atmospereShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pageobject.AbstractPage;

import java.util.List;

public class CardPage extends AbstractPage {

    public CardPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBys({
            @FindBy(xpath = "//span[contains(@class, 'sc-product__property__value')]")
    })
    private List<WebElement> properties;


    public String findProperty(String propertyName){
        for (WebElement property : properties) {
            String[] values = property.getText().split(":");
            if (values[0].equalsIgnoreCase(propertyName)){
                return values[1];
            }
        }
        return "";
    }
}
