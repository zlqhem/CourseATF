/**
 * 
 */
package com.example.i2at.tc.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;

import com.example.i2at.tc.InvalidTemperatureException;
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
	
	TemperatureConverter m_Tc;

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
		/* TODO 6: 占쏙옙逾わ옙�뫀猷꾬옙占쏙옙遺용뎁占썩뫀猷꾤몴占쏙옙�뮆以� 癰귨옙�넎占쏙옙占쏙옙占쎈뜆堉깍옙占쏙옙占� (疫꿸퀡占� 揶쏅�れ벥 占쎈뜆�뒠占썬끉媛먲옙占�0.005 嚥∽옙揶쏉옙�젟)
		 * 沃섎챶�봺 餓ο옙�돩 占쏙옙癰귨옙�넎 占쎈슣�뵠�뇡遺우뱽 筌〓챷�쒙옙�꼷肉� 占쎈쵐苑�(sConversionTableDouble)
		 */
		Iterator itr = sConversionTableDouble.keySet().iterator();
		while(itr.hasNext()){
			double c = (Double)itr.next();
			double f = sConversionTableDouble.get(c);
			assertEquals(c, m_Tc.fahrenheitToCelsius(f));
		}
	}

	/**
	 * Test method for {@link com.example.i2at.tc.TemperatureConverter#fahrenheitToCelsius(double)}.
	 */
	public void testCelsiusToFahrenheit() {
		/* TODO 6: 占쏙옙逾わ옙�뫀猷꾬옙占쏙옙遺용뎁占썩뫀猷꾤몴占쏙옙�뮆以� 癰귨옙�넎占쏙옙占쏙옙占쎈뜆堉깍옙占쏙옙占� (疫꿸퀡占� 揶쏅�れ벥 占쎈뜆�뒠占썬끉媛먲옙占�0.005 嚥∽옙揶쏉옙�젟)
		 * 沃섎챶�봺 餓ο옙�돩 占쏙옙癰귨옙�넎 占쎈슣�뵠�뇡遺우뱽 筌〓챷�쒙옙�꼷肉� 占쎈쵐苑�(sConversionTableDouble)
		 */	
		Iterator itr = sConversionTableDouble.keySet().iterator();
		while(itr.hasNext()){
			double c = (Double)itr.next();
			double f = sConversionTableDouble.get(c);
			assertEquals(f, m_Tc.celsiusToFahrenheit(c));
		}
	}
	
	public final void testExceptionForLessThanAbsoluteZeroF() {
		/* TODO 7: 揶쏅�る퓠 占썬끇履잌첎占썼쳸�뮇源�占쎈뜆�뱽 占쏙옙占쎌늿�뵬占쏙옙field 占쏙옙占쎌뮉�겱占쎌꼷堉깍옙占쏙옙占�*/
		try {
			TemperatureConverter.fahrenheitToCelsius(TemperatureConverter.ABSOLUTE_ZERO_F-1);
			fail("Less than absolute zero F not detected");
		}
		catch (InvalidTemperatureException ex) {
		
		}
	}
	
	public final void testExceptionForLessThanAbsoluteZeroC() {
		/* TODO 7: 揶쏅�る퓠 占썬끇履잌첎占썼쳸�뮇源�占쎈뜆�뱽 占쏙옙占쎌늿�뵬占쏙옙field 占쏙옙占쎌뮉�겱占쎌꼷堉깍옙占쏙옙占�*/
		try {
			TemperatureConverter.celsiusToFahrenheit(TemperatureConverter.ABSOLUTE_ZERO_C-1);
			fail("Less than absolute zero C not detected");
		}
		catch (InvalidTemperatureException ex) {
			
		}
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
