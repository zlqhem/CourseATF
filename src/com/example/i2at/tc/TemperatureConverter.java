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
		double result = 0.0;
		result = (f-32) * (5/9.0);
		result = Math.round(result * 100) / (double)100.0;

		return result;
		//return 0.27777;
	}

	public static double celsiusToFahrenheit(double c) {
		double result = 0.0;
		result = ( (9/5.0) * c ) + 32;
		result = Math.round(result * 100) / (double)100.0;

		return result;
		//return 32.5;
	}

}










