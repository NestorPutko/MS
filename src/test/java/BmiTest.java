import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BmiTest {

    static WebDriver driver = new ChromeDriver();

    @BeforeAll
    public static void setUp() {
        driver.manage().window().maximize();
        driver.get("https://bmi-online.pl/");
    }

    @Test
    public void calculateBmi() {
        //------------radio Button
        List<WebElement> radioList = driver.findElements(By.cssSelector(".radio-btn"));
        if (radioList.get(1).isSelected()) {
            radioList.get(0).click();
        }
        //---------------uzupełnienie pól
        driver.findElement(By.cssSelector("input[name = 'weight']")).sendKeys("55");
        driver.findElement(By.cssSelector("input[name = 'height']")).sendKeys("170");
        //------click
        driver.findElement(By.xpath("//span[text() = 'Przejdź do serwisu']")).click();
        driver.findElement(By.xpath("//span[text() = 'Oblicz']")).click();

        Assertions.assertEquals("19.03", driver.findElement(By.cssSelector(".result-value")).getText());
    }
}
