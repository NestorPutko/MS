import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TablesTest {

    static WebDriver driver = new ChromeDriver();

    @BeforeAll
    public static void setUp(){
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
    }

    @Test
    public void checkTable() {
        List<WebElement> rowsTable = driver.findElements(By.cssSelector("#customers tr"));
        Assertions.assertEquals(7, rowsTable.size());
        String companyName = driver.findElement(By.xpath("//table[@id='customers']//tr[7]//td[2]")).getText();
        Assertions.assertEquals("Giovanni Rovelli", companyName);
        String country = driver.findElement(By.xpath("//table[@id='customers']//tr[td[text() = " +
                "'Centro comercial Moctezuma']]//td[3]")).getText();
        Assertions.assertEquals("Mexico", country);
        String country1 = driver.findElement(By.xpath("//table[@id='customers']//tr[td[text() = " +
                "'Laughing Bacchus Winecellars']]//td[3]")).getText();
        Assertions.assertEquals("Canada", country1);
    }
}
