import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TyposTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void typosTest() {
        driver.get("http://the-internet.herokuapp.com/typos");
        String Text = driver.findElement(By.className("example")).getText();
        assertEquals(Text, "Typos\n" +
                "This example demonstrates a typo being introduced. It does it randomly on each page load.\n" +
                "Sometimes you'll see a typo, other times you won't.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
