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
		return Math.round(100.0 * (f - 32) / 1.8) / 100.0;
	}

	public static double celsiusToFahrenheit(double c) {
		return Math.round(100.0 * (c * 1.8 + 32)) / 100.0;
	}

}










