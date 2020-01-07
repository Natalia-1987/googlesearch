package pageobject;

import common.model.HotlineItem;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotlinePage extends AbstractPage{

    @FindBys({
            @FindBy(xpath = "//li[@class='product-item']")
    })
    private List<WebElement> hotlineProducts;

    @FindBy(xpath = "//select[@name='sort']")
    private WebElement sortSelect;

    private static final String TITLE_LOCATOR = ".//p[@class='h4']";
    private static final String PRICE_LOCATOR = ".//span[@class='value']";

    private WebDriver webDriver;

    private Logger logger = Logger.getLogger(HotlinePage.class);

    public HotlinePage(WebDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    public void orderBy(String text){
            Select orderSelect = new Select(sortSelect);
            orderSelect.selectByVisibleText(text);
    }

    public List<HotlineItem> getHotlineProducts(){

        List<HotlineItem> hotlineItems = new ArrayList<>();

        for (WebElement product : hotlineProducts) {

            String title = product.findElement(By.xpath(TITLE_LOCATOR)).getText();
            Integer price = Integer.valueOf(product.findElement(By.xpath(PRICE_LOCATOR)).getText());

            HotlineItem hotlineItem = new HotlineItem(title, price);
            hotlineItems.add(hotlineItem);
        }

        return hotlineItems;
    }

    public List<HotlineItem> getHotlineItemsUsingStreamApi(){
        return hotlineProducts.stream()
                .map(product -> {
                    String title = product.findElement(By.xpath(TITLE_LOCATOR)).getText();
                    Integer price = Integer.valueOf(product.findElement(By.xpath(PRICE_LOCATOR)).getText());
                    return new HotlineItem(title, price);
                }).collect(Collectors.toList());
    }
}