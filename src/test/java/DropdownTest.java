import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class DropdownTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void dropdownTest() {
        // заходим на сайт
        driver.get("http://the-internet.herokuapp.com/dropdown");
        // находим элемент - строку с dropdpwn
        Select select = new Select(driver.findElement(By.id("dropdown")));
        // выбираем Option 1
        select.selectByVisibleText("Option 1");
        // сравниваем полученное значение с ожидаемым
        assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
        // выбираем Option 2
        select.selectByVisibleText("Option 2");
        // сравниваем полученное значение с ожидаемым
        assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
