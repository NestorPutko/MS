import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.softie.Calculator;

public class CalculatorTest {

    @Test
    public void addErrorTest() {
        Assertions.assertFalse(5 == Calculator.add(4,9));
    }

    @Test
    public void addTest() {
        Assertions.assertTrue(5 == Calculator.add(4,1));
    }

    @Test
    public void substractErrorTest() {
        Assertions.assertFalse(54 == Calculator.substract(71,9));
    }

    @Test
    @Disabled("Enabled when substract method is fixed")
    public void substractTest() {
        Assertions.assertTrue(5 == Calculator.substract(10,5));
    }

    @Test
    public void multiplayErrorTest() {
        Assertions.assertFalse(5 == Calculator.multiply(5,2));
    }

    @Test
    public void multiplayTest() {
        Assertions.assertTrue(5 == Calculator.multiply(5,1));
    }
}
