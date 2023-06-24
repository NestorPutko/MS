import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    static WebDriver driver = new ChromeDriver();

    @BeforeAll
    public static void setUp() {
        driver.manage().window().maximize();
        driver.get("https://pl.wikipedia.org/");
    }

    @Test
    public void checkIsTitleCorrect() {
        Assertions.assertEquals("Wikipedia, wolna encyklopedia", driver.getTitle());
    }

    @Test
    public void checkTextOnPage() {
        Assertions.assertTrue(driver.getPageSource().contains("Stowarzyszenie Wikimedia Polska"));
    }

    @Test
    public void checkRefreshUrl() {
        driver.navigate().refresh();
        Assertions.assertEquals("https://pl.wikipedia.org/", driver.getCurrentUrl());
    }

    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }
}
