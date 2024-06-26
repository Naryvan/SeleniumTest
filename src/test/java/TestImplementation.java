import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.findElement(By.className("VfPpkd-RLmnJb")).click();
        driver.findElement(By.className("whsOnd zHQkBf")).sendKeys("Qwerty123_");
        driver.findElement(By.className("VfPpkd-RLmnJb")).click();
        assertThat(driver.getTitle(), containsString("inbox"));
    }

}
