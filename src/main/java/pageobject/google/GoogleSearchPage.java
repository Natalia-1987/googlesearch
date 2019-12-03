package pageobject.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class GoogleSearchPage {


    @FindBy (name = "q")
    private WebElement searchInput;

    @FindBys({
            @FindBy (xpath = "//li[@class='sbct' and not(@id='sbt')]")
    })

    private List<WebElement> predictiveSearchList;

    public GoogleSearchPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public void searchFor(String searchText){
        searchInput.sendKeys(searchText);
    }

    public List<String> getPredictiveSearchListText(){
        return  predictiveSearchList
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
