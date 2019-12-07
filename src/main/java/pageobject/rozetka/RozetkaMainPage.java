package pageobject.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class RozetkaMainPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='header__logo']/img")
    private WebElement headerLogo;

    public RozetkaMainPage(WebDriver webDriver){
        super(webDriver);
    }

    public String getHeaderLogoTitle(){
        webDriverWait.until(ExpectedConditions.visibilityOf(headerLogo));
        return headerLogo.getAttribute("title");
    }

}
