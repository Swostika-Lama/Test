package TemperatureConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TemperatureConverter converter = new TemperatureConverter();

        System.out.println("Enter temperature in Fahrenheit : ");

        double f = input.nextDouble();
        double c = converter.fahrenheitToCelsius(f);

        System.out.println("Celsius: "+ c);

        System.out.println(" Enter temperature in Celsius: ");
        double c2 = input.nextDouble();
        double f2 = converter.celsiusToFahrenheit(c2);

        System.out.println("Fahrenheit :" + f2);

        System.out.println(" Enter celsius temperature to check if it is extreme or not: ");

        double c3 = input.nextDouble();
        boolean extreme = converter.isExtremeTemperature(c3);

        System.out.println(" Is Extreme :" + extreme);
    }
}
