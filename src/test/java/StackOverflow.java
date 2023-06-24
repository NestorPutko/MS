import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StackOverflow {

    static WebDriver driver = new ChromeDriver();

    @BeforeAll
    public static void setUp() {
        driver.manage().window().maximize();
        driver.get("http://stackoverflow.com");
    }

    @Test
    public void findElemntsOnPage() {
        driver.findElement(By.className("s-topbar--menu-btn"));
        driver.findElement(By.name("q"));
        driver.findElement(By.linkText("Log in"));
        driver.findElement(By.partialLinkText("Join the"));
        ///-----------------------------------
        List<WebElement> search = driver.findElements(By.name("q"));
        System.out.println(search.size());
    }
}
