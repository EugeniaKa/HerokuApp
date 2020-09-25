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

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxTest {

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
    public void checkBoxTest() {
        // заходим на сайт
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        // находим коллекцию полей checkbox
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        // проверяем, что первый чекбокс не выбран
        assertFalse(checkboxes.get(0).isSelected(), "Первый чекбокс не должен быть выбран");
        // кликаем по первому чекбоксу, выбирая его
        checkboxes.get(0).click();
        // проверяем, что первый чекбокс выбран
        assertTrue(checkboxes.get(0).isSelected());
        // проверяем, что второй чекбокс выбран
        assertTrue(checkboxes.get(1).isSelected());
        // кликаем по второму чекбоксу
        checkboxes.get(1).click();
        // проверяем, что второй чекбокс не выбран
        assertFalse(checkboxes.get(1).isSelected());
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
