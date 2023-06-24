import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstTest {

    @Test //adnotacja test
    public void ex1() {
        System.out.println("hello");
    }

    @Test
    public void ex2() {
        Assertions.assertEquals(123, 123);
    }

    @Test
    public void ex3() {
        Assertions.assertEquals(true, 3 > 2, "To nie jest prawdą");
    }

    @Test
    public void ex4() {
        String text = "To jest tekst";
        Assertions.assertEquals(text, text);
     //   Assertions.assertEquals("eryk123", "eryk123");
    }

    @Test
    public void ex5() {
        Assertions.assertEquals("ERYK123", "eryk123".toUpperCase());
    }

    @Test
    public void ex6() {
        int result = addNumbers(3,6);
        Assertions.assertEquals(9, result, "Sum isn't correct");
        Assertions.assertTrue(9 == result, "Sum isn't correct");
    }

    @Test
    public void ex7() {
        double result = circle(1);
        Assertions.assertEquals(3.14, result);

        Assertions.assertEquals(3.14, circle(1));
    }

    @Test
    public void ex8() {
        String text = "     Ala ma kota     ";
        Assertions.assertEquals("ALA MA KOTA", removeSpaces(text));
    }

    private String removeSpaces(String text) {
        return text.trim().toUpperCase();
    }

    private double circle(int r) {
        return 3.14 * r * r;
    }
    private int addNumbers(int a, int b) {
        return a+b;
    }
}
