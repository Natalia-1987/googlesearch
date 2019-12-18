package pageobject.w3school;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.AbstractPage;

public class W3SchoolMainPage extends AbstractPage {

    @FindBy(xpath = "//iframe[@src='default.asp']")
    private WebElement iframe;

    @FindBy(xpath = "//a[@title='CSS Tutorial']")
    private WebElement menuItem;

    public W3SchoolMainPage(WebDriver webDriver){
        super(webDriver);
    }

    public void selectMenuItem(){
        webDriver.switchTo().frame(iframe);
        menuItem.click();
    }

    public String getSelectedMenuItemColor(){
        return menuItem.getCssValue("background-color");
    }
}
