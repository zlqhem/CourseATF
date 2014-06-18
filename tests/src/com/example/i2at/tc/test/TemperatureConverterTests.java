/**
 * 
 */
package com.example.i2at.tc.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import com.example.i2at.tc.TemperatureConverter;

import junit.framework.TestCase;

/**
 * @author diego
 *
 */
public class TemperatureConverterTests extends TestCase {

	private static final HashMap<Double, Double> sConversionTableDouble =
			new HashMap<Double, Double>();
	
	static {
		sConversionTableDouble.put(0.0, 32.0);
		sConversionTableDouble.put(100.0, 212.0);
		sConversionTableDouble.put(-1.0, 30.20);
		sConversionTableDouble.put(-100.0, -148.0);
		sConversionTableDouble.put(32.0, 89.60);
		sConversionTableDouble.put(-40.0, -40.0);
		sConversionTableDouble.put(-273.0, -459.40);
	}

	/**
	 * @param name
	 */
	public TemperatureConverterTests(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link com.example.i2at.tc.TemperatureConverter#fahrenheitToCelsius(double)}.
	 */
	public void testFahrenheitToCelsius() {
		/* TODO 6: ��뵪�⑤룄���붿뵪�⑤룄瑜��쒕줈 蹂�솚�����덉뼱���� (湲곕� 媛믪쓽 �덉슜�ㅼ감��0.005 濡�媛�젙)
		 * 誘몃━ 以�퉬 ��蹂�솚 �뚯씠釉붿쓣 李몄“�섏뿬 �묒꽦(sConversionTableDouble)
		 */
		double expected;
		double actual;
		double delta;
		
		for(double key : sConversionTableDouble.keySet()) {
			double values = sConversionTableDouble.get(key);
			expected = key;
			actual = TemperatureConverter.fahrenheitToCelsius(values);
			delta = Math.abs(expected - actual);
			assertTrue("delta=" + delta + " expected=" + expected + " actual=" + actual, delta < 0.005);
		}
	}

	/**
	 * Test method for {@link com.example.i2at.tc.TemperatureConverter#fahrenheitToCelsius(double)}.
	 */
	public void testCelsiusToFahrenheit() {
		/* TODO 6: ��뵪�⑤룄���붿뵪�⑤룄瑜��쒕줈 蹂�솚�����덉뼱���� (湲곕� 媛믪쓽 �덉슜�ㅼ감��0.005 濡�媛�젙)
		 * 誘몃━ 以�퉬 ��蹂�솚 �뚯씠釉붿쓣 李몄“�섏뿬 �묒꽦(sConversionTableDouble)
		 */		
		double expected;
		double actual;
		double delta;
		
		for(double key : sConversionTableDouble.keySet()) {
			expected = sConversionTableDouble.get(key);
			actual = TemperatureConverter.celsiusToFahrenheit(key);
			delta = Math.abs(expected - actual);
			assertTrue("delta=" + delta + " expected=" + expected + " actual=" + actual, delta < 0.005);
		}
	}
	
	public final void testExceptionForLessThanAbsoluteZeroF() {
		/* TODO 7: 媛믪뿉 �ㅻ쪟媛�諛쒖깮�덉쓣 ���숈씪��field ���쒗쁽�섏뼱����*/	
	}
	
	public final void testExceptionForLessThanAbsoluteZeroC() {
		/* TODO 7: 媛믪뿉 �ㅻ쪟媛�諛쒖깮�덉쓣 ���숈씪��field ���쒗쁽�섏뼱����*/	
	}
	
	public final void testPrivateConstructor() throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, InstantiationException, IllegalAccessException,
			InvocationTargetException {
		Constructor<TemperatureConverter> ctor =
			TemperatureConverter.class.getDeclaredConstructor();
		ctor.setAccessible(true);
		TemperatureConverter tc = ctor.newInstance((Object[])null);
		assertNotNull(tc);
	}
}
