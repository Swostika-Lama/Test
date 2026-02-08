// java.laskin;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
/*
 * JUnit 5
 */

public class CalculatorTest { // The class name must end with Test

    // Fixture: all tests use the same calculator,
    // which is reset before each test.
    private Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @BeforeEach
    public void clearCalculator() {
        calculator.reset();
    }

    // The test method name can be anything, as long as it has the @Test annotation
    @Test
    public void testAdd() {
        calculator.add(1.0);
        calculator.add(2.0);
        assertEquals(3.0, calculator.getResult(), DELTA,"The sum of numbers 1.0 and 2.0 is incorrect");
    }

    @Test
    public void testSubtract() {
        calculator.add(10.5);
        calculator.subtract(2.5);
        assertEquals(8.0, calculator.getResult(),DELTA,"The difference between 10.5 and 2.5 is incorrect");
    }

    @Test
    @DisplayName("Test division 8.5 / 2.0")
    public void testDivide() {
        calculator.add(8.5);
        calculator.divide(2.0);
        assertEquals(4.25, calculator.getResult(), DELTA,"Division 8.5/2.0 is incorrect");
    }

    // The correct result of this test is that division by zero throws an exception,
    // the caller then handles it in the desired way
    @Test
    @DisplayName("Test division by zero")
    public void testDivideByZero() {
        ArithmeticException exception =
                assertThrows(ArithmeticException.class, () -> calculator.divide(0.0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }


    @Test
    public void testMultiply() {
        calculator.add(5.0);
        calculator.multiply(4.0);
        assertEquals(20.0, calculator.getResult(),DELTA, "Multiplication 5.0 * 4.0 is incorrect");
    }

    @Test
    public void testSquare() {
        calculator.square(4.0);
        assertEquals(16.0, calculator.getResult(), DELTA, "Square of 4.0 is incorrect");
    }

    @Test
    public void testSquareRoot() {
        calculator.squareRoot(16.0);
        assertEquals(4.0, calculator.getResult(), DELTA, "Square root of 16 is incorrect");
    }

    @Test
    public void testSquareRootNegative() {
        assertThrows(ArithmeticException.class, () -> calculator.squareRoot(-5.0),
                "Square root of negative number should throw ArithmeticException");
    }

}
