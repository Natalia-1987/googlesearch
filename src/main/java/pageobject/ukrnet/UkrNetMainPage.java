package pageobject.ukrnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

import java.util.Set;

public class UkrNetMainPage extends AbstractPage {

    private static String currentWindowHandle;

    @FindBy(xpath = "(//ul[@class='feed__section--top']//li)[1]")
    private WebElement firstArticle;

    public UkrNetMainPage(WebDriver webDriver){
        super(webDriver);
    }

    public UkrNetArticleDetailsPage selectFirstArticle(){

        webDriverWait.until(ExpectedConditions.visibilityOf(firstArticle));

        firstArticle.click();

        currentWindowHandle = webDriver.getWindowHandle();

        System.out.println("Inside main page. Window handle is: " + currentWindowHandle);

        Set<String> windowHandles = webDriver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            webDriver.switchTo().window(windowHandle);
        }

//        UkrNetArticleDetailspage ukrNetArticleDetailspage = new UkrNetArticleDetailspage(webDriver);
//        return ukrNetArticleDetailspage;
        return new UkrNetArticleDetailsPage(webDriver);
    }

    public String getFirstArticleText(){
        return firstArticle.getText();
    }
}
