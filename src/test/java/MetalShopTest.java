import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MetalShopTest {
    static WebDriver driver = new ChromeDriver();
    Faker faker = new Faker();
    private String username = "softie0423";
    private String password = "test123";
    private String wrongPass= "test";

    @BeforeAll
    public static void setUp() {
        driver.manage().window().maximize();
        driver.navigate().to("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void loginSuccess() {
        driver.findElement(By.linkText("Moje konto")).click();
        driver.findElement(By.cssSelector("#username")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector(".woocommerce-form-login__submit")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//a[contains(text() , 'Kokpit')]")).isDisplayed()
                        && driver.findElement(By.xpath("//a[text() = 'Wyloguj się']")).isDisplayed());
    }

    @Test
    public void wrongPasswordLogin() {
        driver.findElement(By.linkText("Moje konto")).click();
        driver.findElement(By.cssSelector("#username")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(wrongPass);
        driver.findElement(By.cssSelector(".woocommerce-form-login__submit")).click();
        Assertions.assertEquals(String.format("Błąd: wpisano niepoprawne hasło dla użytkownika %s. Nie pamiętasz hasła?",username),
                driver.findElement(By.cssSelector(".woocommerce-error")).getText());
    }

    @Test
    public void successRegister() {

        String username = faker.name().username();
        System.out.println(username);
        String email = username + faker.name().username() +"@wp.pl";
        System.out.println(email);
        //przejście do zakładki register
        driver.findElement(By.linkText("register")).click();
        //--------username
        driver.findElement(By.cssSelector("#user_login")).sendKeys(username);
        driver.findElement(By.cssSelector("#user_email")).sendKeys(email);

        driver.findElement(By.cssSelector("#user_confirm_password")).sendKeys(password);
        driver.findElement(By.cssSelector("#user_pass")).sendKeys(password);
        //przycisk
        driver.findElement(By.cssSelector(".ur-submit-button")).click();
        //----------------Asercje
        Assertions.assertEquals("User successfully registered.", driver.findElement(By.cssSelector("#ur-submit-" +
                "message-node ul")).getText());
    }

    @Test
    public void checkActions() {
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.cssSelector(".woocommerce-Price-amount"))).build().perform();
    }

    @AfterEach
    public void logout() {
        driver.findElement(By.linkText("Moje konto")).click();
        if (driver.findElements(By.xpath("//a[text() = 'Wyloguj się']")).size() != 0) {
            driver.findElement(By.xpath("//a[text() = 'Wyloguj się']")).click();
        }
    }

    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }
}
