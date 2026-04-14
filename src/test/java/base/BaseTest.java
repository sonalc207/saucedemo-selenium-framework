package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup()
    {
    	driver = new SafariDriver();
    	driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

   
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}