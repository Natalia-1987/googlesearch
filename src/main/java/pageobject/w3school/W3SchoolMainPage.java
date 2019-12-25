package pageobject.w3school;

import org.apache.log4j.Logger;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class W3SchoolMainPage {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private Actions actions;

    @FindBy(xpath = "//a[@title='CSS-1  Tutorial']")
    private WebElement cssMenuButton;

    @FindBy(xpath = "//a[@title='JavaScript Tutorial']")
    private WebElement javascriptMenuButton;

    @FindBy(xpath = "//iframe[@src='default.asp']")
    private WebElement iframe;

    private Logger logger = Logger.getLogger(W3SchoolMainPage.class);

    public W3SchoolMainPage(WebDriver webDriver){

        this.webDriver = webDriver;

        actions = new Actions(webDriver);

        webDriverWait = new WebDriverWait(webDriver, 30);

        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        webDriver.manage().window().maximize();
    }

    public void clickCssButton(){
        webDriver.switchTo().frame(iframe);
        try {
            cssMenuButton.click();
        } catch (NotFoundException e){
            logger.trace("Element not found ecxeption", e.fillInStackTrace());
        }
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(cssMenuButton));

        actions.moveToElement(javascriptMenuButton).build().perform();
    }

    public String getCssMenuButtonItemPresentColor(){
        String color = cssMenuButton.getCssValue("background-color");
        return color;
    }
}
