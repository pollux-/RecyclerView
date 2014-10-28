package com.demo.recylerview.utils;

import android.os.Build;

public class Utils {

	public static boolean isHoneyCombMR1AndAbove() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;

	}

}
