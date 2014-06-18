package com.example.i2at.tc;

public class InvalidTemperatureException extends RuntimeException {
	public InvalidTemperatureException(String msg) {
		super(msg);
	}
}