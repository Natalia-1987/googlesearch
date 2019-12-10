package pageobject.atmospereShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pageobject.AbstractPage;

import java.util.List;
import java.util.Random;

public class ProductPage extends AbstractPage {
    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (xpath = "//h1[@class='global-page-header__title']")
    private WebElement title;

    @FindBy(xpath = "//div[@class='product-detail__color']/h3/span")
    private WebElement color;

    @FindBys({
            @FindBy (xpath = "//div[contains(@class, 'product-detail__size')]/div/div/a")
    })
    private List<WebElement> sizes;

    @FindBy(xpath = "//button[contains(@class, 'add-cart')]")
    private WebElement addButton;

    @FindBy (xpath = "//div[contains(@class, 'header-cart')]/a")
    private WebElement cartIcon;

    public String getProductName(){
        return title.getText();
    }

    public String getColor() {
        return color.getText();
    }

    public String clickRandomSize(){
        Random random = new Random();
        WebElement size = sizes.get(random.nextInt(sizes.size() - 1));
        String text = size.getText();
        size.click();
        return text;
    }

    public void clickAdd(){
        addButton.click();
    }

    public void goToCart(){
        cartIcon.click();
    }
}
