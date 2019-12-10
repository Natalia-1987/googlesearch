package google;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pageobject.atmospereShop.CardPage;
import pageobject.atmospereShop.MainPage;
import pageobject.atmospereShop.ProductPage;

public class AtmosphereStoreTestsSuite extends BaseTest {

    @Test
    public void test1() {
        Parkas parkas = new Parkas();

        String googleUrl = propertyHelper.readProperty("site.url");
        webDriver.get(googleUrl);
        MainPage mainpage = new MainPage(webDriver);
        mainpage.searchFor("parkas");

        mainpage.clickSearch();

        mainpage.selectItem();

        ProductPage productPage = new ProductPage(webDriver);

        parkas.setName(productPage.getProductName());
        parkas.setColor(productPage.getColor());
        parkas.setSize(productPage.clickRandomSize());

        System.out.println(parkas);

        productPage.clickAdd();
        productPage.goToCart();

        CardPage cardPage = new CardPage(webDriver);

        Assert.assertEquals("name is wrong", parkas.getName(), cardPage.getName());
        Assert.assertEquals("color is wrong", parkas.getColor(), cardPage.findProperty("colour"));
        Assert.assertEquals("size is wrong", parkas.getSize(), cardPage.findProperty("size"));
    }
}
