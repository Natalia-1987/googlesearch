package pageobject.ukrnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class UkrNetArticleDetailspage extends AbstractPage {

    @FindBy(xpath = "//h1")
    private WebElement articleHead;

    public UkrNetArticleDetailspage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getarticleHeadText(){
        webDriverWait.until(ExpectedConditions.visibilityOf(articleHead));
        return articleHead.getText();
    }
}
