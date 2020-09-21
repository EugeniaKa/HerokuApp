import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AddRemoveElementsTest {


    WebDriver driver;

    @BeforeTest
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void addRemoveElementsTest () {
        // запустить сайт
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        // найти кнопку Add
        WebElement add = driver.findElement(By.xpath(".//button[text()='Add Element']"));
        // кликнуть дважды
        add.click();
        add.click();
        // получаем коллекцию кнопок Delete
        List<WebElement> deleteButton = driver.findElements(By.xpath (".//button[text()='Delete']"));
        assertEquals(deleteButton.size(), 2);
        // кликаем для удаления на вторую кнопку
        deleteButton.get(1).click();
        assertEquals(driver.findElements(By.xpath (".//button[text()='Delete']")).size(), 1);

    }


    @AfterTest
    public void tearDown () {
        driver.quit();
    }
}