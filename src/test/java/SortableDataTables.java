import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SortableDataTables {

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
    public void sortableDataTablesTest() {
        // открываем сайт
        driver.get("http://the-internet.herokuapp.com/tables");
        // находим элемент с координатами: первая таблица, 1я стока, 1й столбец
        WebElement info = driver.findElement(By.xpath("//table//tr[1]//td[1]"));
        // считываем текст
        info.getText();
        // сравниваем с ожидаемым результатом
        assertEquals(info.getText(), "Smith");
    }

    @Test
    public void sortableDataTablesTest1() {
        // открываем сайт
        driver.get("http://the-internet.herokuapp.com/tables");
        // находим элемент с координатами: 2я таблица, 1я стока, 2й столбец
        WebElement info = driver.findElement(By.xpath("//table[2]//tr[1]//td[2]"));
        // считываем текст
        info.getText();
        // сравниваем с ожидаемым результатом
        assertEquals(info.getText(), "John");
    }

    @Test
    public void sortableDataTablesTest2() {
        // открываем сайт
        driver.get("http://the-internet.herokuapp.com/tables");
        // находим элемент с координатами: 1я таблица, 4я стока, 5й столбец
        WebElement info = driver.findElement(By.xpath("//table[1]//tr[4]//td[5]"));
        // считываем текст
        info.getText();
        // сравниваем с ожидаемым результатом
        assertEquals(info.getText(), "http://www.timconway.com");
    }

    @Test
    public void sortableDataTablesTest3() {
        // открываем сайт
        driver.get("http://the-internet.herokuapp.com/tables");
        // находим элемент с координатами: 2я таблица, 3я стока, 4й столбец
        WebElement info = driver.findElement(By.xpath("//table[2]//tr[3]//td[4]"));
        // считываем текст
        info.getText();
        // сравниваем с ожидаемым результатом
        assertEquals(info.getText(), "$100.00");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
