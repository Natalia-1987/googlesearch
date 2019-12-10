package pageobject.atmospereShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pageobject.AbstractPage;

import java.util.List;
import java.util.Random;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//input[@data-module-type='TextFieldPlaceholder']")
    private WebElement searchInput;

    @FindBy (xpath = "//input[@type='submit']")
    private WebElement searchButton;

    @FindBys({
            @FindBy (xpath = "//a[@class='product-grid__link']")
    })

    private List<WebElement> searchList;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void searchFor(String searchText){
        searchInput.sendKeys(searchText);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public void selectItem() {
        Random random = new Random();
        searchList.get(random.nextInt(searchList.size()-1)).click();
    }
}
