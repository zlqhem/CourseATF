/**
 * 
 */
package com.example.i2at.tc;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * @author diego
 *
 */
public class EditNumber extends EditText {

	/**
	 * @param context
	 */
	public EditNumber(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public EditNumber(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public EditNumber(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public void clear() {
		setText("");
	}

	public void setNumber(double f) {
		double rf = Math.round(f*100.0)/100.0;
		android.util.Log.d("setNumber", "setting f=" + f + " => " + Double.toString(rf));
		setText(Double.toString(rf));
	}

	public double getNumber() {
		final String s = getText().toString();
		android.util.Log.d("getNumber", "converting " + s);
		if ( "".equals(s) ) {
			return Double.NaN;
		}
		return Double.valueOf(s);
	}

}
