package TemperatureConverter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    TemperatureConverter converter = new TemperatureConverter();

    @Test
    void testFahrenheitToCelsius() {
        double result = converter.fahrenheitToCelsius(212);
        assertEquals(100.0, result, 0.01);
    }

    @Test
    void testCelsiusToFahrenheit() {
        double result = converter.celsiusToFahrenheit(0);
        assertEquals(32.0, result, 0.01);
    }

    @Test
    void testIsExtremeTemperature() {
        assertTrue(converter.isExtremeTemperature(-45));
        assertTrue(converter.isExtremeTemperature(55));
        assertFalse(converter.isExtremeTemperature(25));
    }
}
