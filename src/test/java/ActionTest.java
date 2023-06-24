import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void gradAndDropTest() {
        driver.manage().window().maximize();
        driver.get("https://www.zalando.pl/odziez-damska-sukienki-koktajlowe/");

        driver.findElement(By.cssSelector("button[aria-label = 'filtruj po Cena']")).click();

        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.cssSelector("div[aria-label = 'Najniższa cena']")))
                .moveByOffset(100,0).build().perform();
    }
}
