package com.demo.recylerview.io;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @author sreekumar
 * 
 */
public class VolleyHelper {

	private static RequestQueue mRequestQueue;
	private static RequestQueue mImageRequestQueue;

	/**
	 * Create separate queue for image and data
	 * 
	 * @param context
	 */
	public static void initQueues(Context context) {
		mRequestQueue = Volley.newRequestQueue(context, false);
		mImageRequestQueue = Volley.newRequestQueue(context, true);

	}

	public static RequestQueue getRequestQueue() {

		if (mRequestQueue != null) {
			return mRequestQueue;
		} else {
			throw new IllegalStateException("RequestQueue not initialized");
		}
	}

	public static RequestQueue getImageRequestQueue() {

		if (mImageRequestQueue != null) {
			return mImageRequestQueue;
		} else {
			throw new IllegalStateException("Image RequestQueue not initialized");
		}
	}

}
