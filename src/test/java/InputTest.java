import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class InputTest {

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
    public void inputTest() {
        // открываем сайт
        driver.get("http://the-internet.herokuapp.com/inputs");
        // находим строку для введения значений
        WebElement input = driver.findElement(By.tagName("input"));
        // записываем в нее "2"
        input.sendKeys("2");
        // нажимаем стрелку вверх
        input.sendKeys(Keys.ARROW_UP);
        // сравниваем полученное значение с ожидаемой тройкой
        assertEquals(input.getAttribute("value"), "3");
        // нажимаем стрелку вниз
        input.sendKeys(Keys.ARROW_DOWN);
        // сравниваем полученное значение с ожидаемой двойкой
        assertEquals(input.getAttribute("value"), "2");
        // передаем букву в строку
        input.sendKeys("a");
        // сравниваем полученное значение с ожидаемой двойкой
        assertEquals(input.getAttribute("value"), "2");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
