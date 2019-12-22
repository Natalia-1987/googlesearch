package pageobject.w3school;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class W3SchoolMainPage extends AbstractPage {

    @FindBy(xpath = "//iframe[@src='default.asp']")
    private WebElement iframe;

    @FindBy(xpath = "//a[@title='JavaScript Tutorial']")
    private WebElement menuItem;

    @FindBy(xpath = "//a[@title='Home']")
    private WebElement homeButton;

    public W3SchoolMainPage(WebDriver webDriver){
        super(webDriver);
    }

    public void selectMenuItem(){
        Actions actions = new Actions(webDriver);
        webDriver.switchTo().frame(iframe);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(menuItem));
        menuItem.click();
        actions.moveToElement(homeButton).build().perform();
    }

    public String getSelectedMenuItemColor(){
        return menuItem.getCssValue("background-color");
    }
}
