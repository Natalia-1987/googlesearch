package pageobject.ukrnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class UkrNetMainPage extends AbstractPage {

    @FindBy(xpath = "(//ul[@class='feed__section--top']//li)[1]")
    private WebElement firstArticle;

    public UkrNetMainPage(WebDriver webDriver){
        super(webDriver);
    }

    public UkrNetArticleDetailspage selectFirstArticle(){
        webDriverWait.until(ExpectedConditions.visibilityOf(firstArticle));
        firstArticle.click();
//        UkrNetArticleDetailspage ukrNetArticleDetailspage = new UkrNetArticleDetailspage(webDriver);
//        return ukrNetArticleDetailspage;
        return new UkrNetArticleDetailspage(webDriver);
    }

    public String getFirstText(){
        return firstArticle.getText();
    }
}
