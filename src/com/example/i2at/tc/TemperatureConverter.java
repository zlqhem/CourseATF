/**
 * 
 */
package com.example.i2at.tc;

/**
 * @author diego
 *
 */
public class TemperatureConverter {
	private TemperatureConverter() {
		// do nothing
	}
	public static double fahrenheitToCelsius(double f) {
		return (f - 32) / 1.8;
	}

	public static double celsiusToFahrenheit(double c) {
		return c * 1.8 + 32;
	}

}










