import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestImplementation {

    private WebDriver driver;

    @BeforeAll
    public static void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifyEmailFieldExists() {
        driver.get("https://www.gmail.com");
        Assertions.assertNotNull(driver.findElement(By.id("identifierId")));
    }

    @Test
    public void verifyButtonExists() {
        driver.get("https://www.gmail.com");
        Assertions.assertNotNull(driver.findElement(By.className("VfPpkd-vQzf8d")));
    }

    @Test
    public void verifyLoginWorks() {
        driver.get("https://www.gmail.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("identifierId")).sendKeys("selenium11037@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        driver.findElement(By.name("Passwd")).sendKeys("Qwerty123_");
        driver.findElement(By.id("passwordNext")).click();
        wait.until(ExpectedConditions.titleContains("Inbox"));
        assertThat(driver.getTitle(), containsString("Inbox"));
    }

}
