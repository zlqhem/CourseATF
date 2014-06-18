/**
 * 
 */
package com.example.i2at.tc.test;

import java.util.HashMap;
import java.util.Iterator;

import com.example.i2at.tc.EditNumber;

import android.test.AndroidTestCase;

/**
 * @author diego
 *
 */
public class EditNumberTests extends AndroidTestCase {

	private EditNumber mEditNumber;

	/**
	 * @param name
	 */
	public EditNumberTests(String name) {
		setName(name);
	}

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		mEditNumber = new EditNumber(mContext);
		mEditNumber.setFocusable(true);
	}

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link com.example.i2at.tc.EditNumber#EditNumber(android.content.Context)}.
	 */
	public final void testEditNumberContext() {
		assertNotNull(mEditNumber);
	}

	/**
     * Test method for {@link com.example.i2at.tc.EditNumber#EditNumber(android.content.Context, android.util.AttributeSet, int)}.
     */
	public final void testEditNumberContextAttributeSetInt() {
	    assertNotNull(new EditNumber(mContext, null, 0));
	}
	
	/**
	 * Test method for {@link com.example.i2at.tc.EditNumber#clear()}.
	 */
	public final void testClear() {
		final String value = "123.45";
		mEditNumber.setText(value);
		mEditNumber.clear();
		final String expected = "";
		final String actual = mEditNumber.getText().toString();
		assertEquals(expected, actual);
	}
	private static final HashMap<String, String> sConversionTableString =
			new HashMap<String, String>();
	
	static {
		sConversionTableString.put("0.0", "0.0");
		sConversionTableString.put("100.1234", "100.xx");
		sConversionTableString.put("-1.0", "-1.0");
		sConversionTableString.put("0.009", "0.01");
		sConversionTableString.put("-0.009", "-0.01");
		sConversionTableString.put("-0.001", "0.0");
		sConversionTableString.put("-99", "-99.0");
		sConversionTableString.put("123", "123.0");
	}
	/**
	 * Test method for {@link com.example.i2at.tc.EditNumber#setNumber(double)}.
	 */
	public final void testSetNumber() {
		/* TODO 8: 값은 10진수로 소수점 둘째 자리까지 표현되어야 함 */

		Iterator<String> itr = sConversionTableString.keySet().iterator();
		while (itr.hasNext()) {
			String srcText = itr.next();
			String expected = sConversionTableString.get(srcText);

			mEditNumber.setNumber(Double.valueOf(srcText));
			String actual = mEditNumber.getText().toString();

			assertTrue("src: " + srcText + ", expected: " + expected
					+ ", actual: " + actual,
					actual.length() == expected.length());
		}
	}

	/**
	 * Test method for {@link com.example.i2at.tc.EditNumber#getNumber()}.
	 */
	public final void testGetNumber() {
		final double expected = 123.45;
		mEditNumber.setNumber(expected);
		final double actual = mEditNumber.getNumber();
		assertEquals(expected, actual);
	}

}
