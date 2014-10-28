package com.demo.recylerview.cache;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;

import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.demo.recylerview.utils.Utils;

/**
 * @author sreekumar
 * 
 */
@SuppressLint("NewApi")
public class BitmapMemoryCache extends LruCache<String, Bitmap> implements ImageCache {

	private static final String TAG = "BitmapMemoryCache";

	public BitmapMemoryCache(int maxSize) {
		super(maxSize);
		Log.i(TAG, "Size: " + maxSize);
	}

	@Override
	protected int sizeOf(String key, Bitmap value) {
		if (Utils.isHoneyCombMR1AndAbove())
			return value.getByteCount();
		else
			return (value.getRowBytes() * value.getHeight());

	}

	@Override
	public Bitmap getBitmap(String url) {
		return get(url);
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		put(url, bitmap);
	}

}
