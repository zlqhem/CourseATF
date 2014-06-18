/**
 * Copyright (C) 2011 Diego Torres Milano
 */

package com.example.i2at.tc.test;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.SmallTest;
import android.test.suitebuilder.annotation.Suppress;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;

import com.example.i2at.tc.EditNumber;
import com.example.i2at.tc.TemperatureConverter;
import com.example.i2at.tc.TemperatureConverterActivity;

/**
 * @author diego
 */
public class TemperatureConverterActivityTests extends
        ActivityInstrumentationTestCase2<TemperatureConverterActivity> {

    private static final String MINUS_SIGN = "-";
    private TemperatureConverterActivity mActivity;
    private EditNumber mCelsius;
    private EditNumber mFahrenheit;
    private Instrumentation mInstrumentation;

    /**
     * @param name
     */
    public TemperatureConverterActivityTests(String name) {
        super(TemperatureConverterActivity.class);
        setName(name);
    }

    /*
     * (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();

        mInstrumentation = getInstrumentation();
        assertNotNull(mInstrumentation);

        mActivity = getActivity();
        assertNotNull(mActivity);

        mCelsius = (EditNumber) mActivity.findViewById(com.example.i2at.tc.R.id.celsius);
        assertNotNull(mCelsius);
        mFahrenheit = (EditNumber) mActivity.findViewById(com.example.i2at.tc.R.id.fahrenheit);
        assertNotNull(mFahrenheit);
    }

    /*
     * (non-Javadoc)
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @SmallTest
    public void testFieldsOnScreen() {
    	final View origin = mActivity.getWindow().getDecorView();
    	ViewAsserts.assertOnScreen(origin, mCelsius);
    	ViewAsserts.assertOnScreen(origin, mFahrenheit);
        /* TODO #2. 섭씨온도를 입력 받는 field 와 화씨온도를 입력받는 field 가 하나씩 존재함
         * Hint: assertOnScreen  
         */
    }

    @SmallTest
    public void testFieldsShouldStartEmpty() {
    	/* TODO #1. 최소 실행 시 각 field 는 비워져 있어야 함
    	 * 	 field : mCelsius, mFahrenheit
    	 */
    }

    @SmallTest
	public void testJustification() {
		/*
		 * TODO 3: 숫자는 오른쪽 정렬로 되어야 하고 수직 중앙 정렬되어야 함 Hint: EditText.getGravity()
		 */
		assertEquals(Gravity.CENTER_VERTICAL, mCelsius.getGravity()
				& Gravity.CENTER_VERTICAL);
		assertEquals(Gravity.RIGHT, mCelsius.getGravity() & Gravity.RIGHT);

		assertEquals(Gravity.CENTER_VERTICAL, mFahrenheit.getGravity()
				& Gravity.CENTER_VERTICAL);
		assertEquals(Gravity.RIGHT, mFahrenheit.getGravity() & Gravity.RIGHT);
    }

    @SmallTest
    public void testVirtualKeyboardSpaceReserved() {
        /* TODO 4: 키보드가 올아올 예비 공간을 Application 상 에서 미리 확보해야 함. */
    }
    
    @UiThreadTest
    public void testFahrenheitToCelsiusConversion() {
    	/* TODO 5-1: 하나의 field 에 값을 입력하면, 다른  field 에 해당 값이 실시간으로 변환되어야 함
        */
        mCelsius.clear();
        mFahrenheit.clear();
        final double f = 32.5;
        assertTrue(mFahrenheit.requestFocus());
        mFahrenheit.setNumber(f);
        assertEquals(f, mFahrenheit.getNumber());
        assertTrue(mCelsius.requestFocus());
        assertTrue(mCelsius.isFocused());
        
        final double expected = 0.28; // COMPLETE 
        final double actual = mCelsius.getNumber(); // COMPLETE
        final double delta = Math.abs(expected - actual);
        assertTrue("delta=" + delta + " expected=" + expected + " actual=" + actual, delta < 0.005);
    	assertTrue(true);
    }

    @UiThreadTest
    public void testCelsiusToFahrenheitConversion() {
    	/* TODO 5-2: 하나의 field 에 값을 입력하면, 다른  field 에 해당 값이 실시간으로 변환되어야 함
        */
        mCelsius.clear();
        mFahrenheit.clear();
        final double c = 100;
        assertTrue(mCelsius.requestFocus());
        mCelsius.setNumber(c);
        assertEquals(c, mCelsius.getNumber());
        assertTrue(mFahrenheit.requestFocus());
        assertTrue(mFahrenheit.isFocused());
        final double expected = 212; // COMEPLETE
        final double actual = mFahrenheit.getNumber(); // COMPLETE
        final double delta = Math.abs(expected - actual);
        assertTrue("delta=" + delta + " expected=" + expected + " actual=" + actual, delta < 0.005);
    	assertTrue(true);
    }

    public void testFahrenheitToCelsiusConversion_text() throws Throwable {
    	/*
        final double f = 32.5;
        runTestOnUiThread(new Runnable() {

            @Override
            public void run() {
                mCelsius.clear();
                mFahrenheit.clear();
                assertTrue(mFahrenheit.requestFocus());
            }
        });

        mInstrumentation.sendStringSync(Double.toString(f));
        assertEquals(f, mActivity.getFahrenheit());
        final double expected = TemperatureConverter.fahrenheitToCelsius(f);
        final double actual = mCelsius.getNumber();
        final double delta = Math.abs(expected - actual);
        assertTrue("delta=" + delta + " expected=" + expected + " actual=" + actual, delta < 0.005);
        */
    }

    public void testCelsiusToFahrenheitConversion_text() throws Throwable {
    	/*
        final double c = 100;
        runTestOnUiThread(new Runnable() {

            @Override
            public void run() {
                mCelsius.clear();
                mFahrenheit.clear();
                assertTrue(mCelsius.requestFocus());
            }
        });
        mInstrumentation.sendStringSync(Double.toString(c));

        runTestOnUiThread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                mActivity.getCelsius();
                assertEquals(c, mCelsius.getNumber());
                assertEquals(c, mActivity.getCelsius());
                final double expected = TemperatureConverter.celsiusToFahrenheit(c);
                final double actual = mFahrenheit.getNumber();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                assertEquals(c, mActivity.getFahrenheit());
                final double delta = Math.abs(expected - actual);
                assertTrue("delta=" + delta + " expected=" + expected + " actual=" + actual,
                        delta < 0.005);
            }
        });
        */
    }

    @UiThreadTest
    public void testCelsiusIncompleteNumberEntered() {
        mCelsius.clear();
        mCelsius.setText(MINUS_SIGN);
        assertTrue(MINUS_SIGN.equals(mCelsius.getText().toString()));
    }

    @UiThreadTest
    public void testFahrenheitIncompleteNumberEntered() {
        mFahrenheit.clear();
        mFahrenheit.setText(MINUS_SIGN);
        assertTrue(MINUS_SIGN.equals(mFahrenheit.getText().toString()));
    }
    
    @Suppress
    public void testOnOptionsItemSelected() {
        final Instrumentation i = getInstrumentation();
        i.sendKeyDownUpSync(KeyEvent.KEYCODE_MENU);
        i.sendKeyDownUpSync(KeyEvent.KEYCODE_ENTER);
        // this is trying to run tests from the menu, which is not going to
        // happen as we are already running instrumentation tests here
        // and there's nothing to verify
        assertTrue(true);
    }

    @Suppress
    public void testForceFail() {
        fail("Forced fail");
    }
}
