
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ExtraTest extends AbstractParent {

    private static Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @BeforeAll
    public static void testPowerOn() {
        System.out.println("@BeforeAll Power ON (before the first test)");
        calculator.powerOn();
    }

    @AfterAll
    public static void testPowerOff() {
        System.out.println("@AfterAll Power OFF (all tests executed).");
        calculator.powerOff();
        calculator = null;
    }

    @BeforeEach
    public void testReset() {
        System.out.println("  Reset calculator.");
        calculator.reset();
        assertEquals(0.0, calculator.getResult(), DELTA,"Reset failed");
    }

    @ParameterizedTest(name = "The square of {0} is {1}")
    @MethodSource("squareTestData")
    @DisplayName("Parameterized square test")
    public void testSquare(double input, double expected) {
        calculator.square(input);
        assertEquals(expected, calculator.getResult(), DELTA,
                "Squaring number " + input + " is incorrect");
    }

    static Stream<Arguments> squareTestData() {
        return Stream.of(
                Arguments.of(2.0, 4.0),
                Arguments.of(4.0, 16.0),
                Arguments.of(5.0, 25.0)
        );
    }

    @Test
    @DisplayName("Square root of 2")
    public void testSquareRoot2() {
        calculator.squareRoot(2.0);
        assertEquals(Math.sqrt(2), calculator.getResult(), DELTA,"Square root of 2 is incorrect");
    }


    @Test
    @DisplayName("Test negative square root")
    public void testSquareRootNegative() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.squareRoot(-5);
        }, "Square root of negative number should throw ArithmeticException");
    }

}
