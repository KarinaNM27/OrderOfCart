import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;


import static org.junit.jupiter.api.Assertions.assertEquals;


class OrderOfCartTest {

    private WebDriver driver;

    @BeforeAll
    static void setupAll() {
        System.setProperty("webdriver.chrome.driver", "driver/win/chromedriver.exe");

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
//        driver = new ChromeDriver(options);

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
//        driver = new ChromeDriver(options);

    }


    @BeforeEach
    void setup() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();

    }


    @Test
    void test() {

        driver.get("http://localhost:7777");


        driver.findElement(By.cssSelector("span[data-test-id='name'] input")).sendKeys("Иванова Мария");
        driver.findElement(By.cssSelector("span[data-test-id='phone'] input")).sendKeys("+79123456789");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.className("button_view_extra")).click();
        String text = driver.findElement(By.className("paragraph")).getText();
        assertEquals("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text);
    }


    @AfterEach
    void teardown() {
        driver.quit();
        driver = null;
    }


}