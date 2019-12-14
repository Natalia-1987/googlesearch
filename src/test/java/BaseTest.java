import lombok.Getter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Getter
public abstract class BaseTest {

    private WebDriver webDriver;

    @Before
    public void setUpDriver(){
        System.setProperty("webdriver.chromedriver", "chromedriver");
        webDriver = new ChromeDriver();
    }

    @After
    public void shutDownDriver(){
        webDriver.close();
        webDriver.quit();
    }
}
