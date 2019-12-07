package pageobject.google;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pageobject.AbstractPage;

import java.util.List;
import java.util.stream.Collectors;

public class GoogleSearchPage extends AbstractPage {


    @FindBy (name = "q")
    private WebElement searchInput;


    @FindBy (xpath = "//li[@productId = '34343434']")
    private WebElement product;

//    public void SelectProductById(String productId){
//        WebElement product = webDriver.findElement(By.xpath(String.format("//*['%s']", productId)));
//        product.click();
//    }


    @FindBys({
            @FindBy (xpath = "//li[@class='sbct' and not(@id='sbt')]")
    })

    private List<WebElement> predictiveSearchList;

    public GoogleSearchPage(WebDriver webDriver){
        super(webDriver);
    }

    public void searchFor(String searchText){
        //wait
        searchInput.sendKeys(searchText);
    }

    public GoogleSearchResultsPage searchForWithEnter (String searchText){
        searchInput.sendKeys(searchText, Keys.ENTER);
        return new GoogleSearchResultsPage(webDriver);
    }

    public List<String> getPredictiveSearchListText(){
        return  predictiveSearchList
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
