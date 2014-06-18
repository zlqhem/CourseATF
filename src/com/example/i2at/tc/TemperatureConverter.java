/**
 * 
 */
package com.example.i2at.tc;

/**
 * @author diego
 *
 */
public class TemperatureConverter {
	public static final double ABSOLUTE_ZERO_C = -273.15d;
	public static final double ABSOLUTE_ZERO_F = -459.67d;
	
	public static final String ERROR_MESSAGE_BELOW_ZERO_FMT =
			"Invalid temperature: %.2f%c below absolute zero";
	
	private TemperatureConverter() {
		// do nothing
	}
	
	public static double fahrenheitToCelsius(double f) {
		if (f < ABSOLUTE_ZERO_F) {
			throw new InvalidTemperatureException(
					String.format(ERROR_MESSAGE_BELOW_ZERO_FMT, f, 'F'));
		}
		double result = 0.0;
		result = (f-32) * (5/9.0);
		result = Math.round(result * 100) / (double)100.0;

		return result;
	}

	public static double celsiusToFahrenheit(double c) {
		if (c < ABSOLUTE_ZERO_C) {
			throw new InvalidTemperatureException(
					String.format(ERROR_MESSAGE_BELOW_ZERO_FMT, c, 'F'));
		}		
		double result = 0.0;
		result = ( (9/5.0) * c ) + 32;
		result = Math.round(result * 100) / (double)100.0;

		return result;
	}
}










