import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void checkText() {
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//button[text() = 'Start']")).click();
        Assertions.assertEquals("Hello World!", driver.findElement(By.cssSelector("#finish")).getText());
    }

    @Test
    public void checkText1() {
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

        driver.findElement(By.xpath("//button[text() = 'Start']")).click();
        Wait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish")));
        Assertions.assertEquals("Hello World!", driver.findElement(By.cssSelector("#finish")).getText());
    }
}
