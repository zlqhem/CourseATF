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
        /* TODO #2. �꽠�뵪�삩�룄瑜� �엯�젰 諛쏅뒗 field �� �솕�뵪�삩�룄瑜� �엯�젰諛쏅뒗 field 媛� �븯�굹�뵫 議댁옱�븿
         * Hint: assertOnScreen  
         */
    }

    @SmallTest
    public void testFieldsShouldStartEmpty() {
    	/* TODO #1. 理쒖냼 �떎�뻾 �떆 媛� field �뒗 鍮꾩썙�졇 �엳�뼱�빞 �븿
    	 * 	 field : mCelsius, mFahrenheit
    	 */
    	assertTrue("".equals(mCelsius.getText().toString()));
    	assertTrue("".equals(mFahrenheit.getText().toString())); 
    }

    @SmallTest
    public void testJustification() {
        /* TODO 3: �닽�옄�뒗 �삤瑜몄そ �젙�젹濡� �릺�뼱�빞 �븯怨� �닔吏� 以묒븰 �젙�젹�릺�뼱�빞 �븿
         * Hint:  EditText.getGravity()
         */
    	assertEquals(Gravity.RIGHT, mCelsius.getGravity());
    	assertEquals(Gravity.RIGHT, mFahrenheit.getGravity());
    }

    @SmallTest
    public void testVirtualKeyboardSpaceReserved() {
        /* TODO 4: �궎蹂대뱶媛� �삱�븘�삱 �삁鍮� 怨듦컙�쓣 Application �긽 �뿉�꽌 誘몃━ �솗蹂댄빐�빞 �븿. */
    }
    
    @UiThreadTest
    public void testFahrenheitToCelsiusConversion() {
    	/* TODO 5-1: �븯�굹�쓽 field �뿉 媛믪쓣 �엯�젰�븯硫�, �떎瑜�  field �뿉 �빐�떦 媛믪씠 �떎�떆媛꾩쑝濡� 蹂��솚�릺�뼱�빞 �븿
        mCelsius.clear();
        mFahrenheit.clear();
        final double f = 32.5;
        assertTrue(mFahrenheit.requestFocus());
        mFahrenheit.setNumber(f);
        assertEquals(f, mFahrenheit.getNumber());
        assertTrue(mCelsius.requestFocus());
        assertTrue(mCelsius.isFocused());
        
        final double expected; // COMPLETE 
        final double actual; // COMPLETE
        final double delta = Math.abs(expected - actual);
        assertTrue("delta=" + delta + " expected=" + expected + " actual=" + actual, delta < 0.005);
        */
    	assertTrue(true);
    }

    @UiThreadTest
    public void testCelsiusToFahrenheitConversion() {
    	/* TODO 5-2: �븯�굹�쓽 field �뿉 媛믪쓣 �엯�젰�븯硫�, �떎瑜�  field �뿉 �빐�떦 媛믪씠 �떎�떆媛꾩쑝濡� 蹂��솚�릺�뼱�빞 �븿
        mCelsius.clear();
        mFahrenheit.clear();
        final double c = 100;
        assertTrue(mCelsius.requestFocus());
        mCelsius.setNumber(c);
        assertEquals(c, mCelsius.getNumber());
        assertTrue(mFahrenheit.requestFocus());
        assertTrue(mFahrenheit.isFocused());
        final double expected; // COMEPLETE
        final double actual; // COMPLETE
        final double delta = Math.abs(expected - actual);
        assertTrue("delta=" + delta + " expected=" + expected + " actual=" + actual, delta < 0.005);
        */
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
