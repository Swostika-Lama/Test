import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// Here the ParameterizedTest annotation is used
// Parameter pairs in a table (comma-separated values)

public class SquareTest {

    private Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @ParameterizedTest(name = "The square of {0} is {1}")
    @CsvSource({ "0.0, 0.0", "1.0, 1.0", "2.0, 4.0","3.0, 9.0", "4.0, 16.0", "5.0, 25.0", "6.0, 36.0" })
    public void testSquare(double number, double result) {
        calculator.square(number);
        assertEquals(result, calculator.getResult(),DELTA, "Squaring does not seem to work correctly");
    }
}
