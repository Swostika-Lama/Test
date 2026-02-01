package TemperatureConverter;


public class TemperatureConverter {

    //Convert Fahrenheit to celsius
    public double fahrenheitToCelsius(double fahrenheit){
        return (fahrenheit -32) * 5.0/9.0;
    }

    //Convert Celsius to Fahrenheit
    public double celsiusToFahrenheit(double celsius){
        return (celsius*9.0/5.0) + 32;
    }

    //checks if a celsius temperature is extreme
    public boolean isExtremeTemperature(double celsius){
        return celsius < -40 || celsius > 50;
    }


}
