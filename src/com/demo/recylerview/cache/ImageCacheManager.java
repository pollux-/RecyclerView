package com.demo.recylerview.cache;

import android.util.Log;

import com.android.volley.toolbox.ImageLoader;
import com.demo.recylerview.io.VolleyHelper;

/**
 * @author sreekumar
 * 
 */
public enum ImageCacheManager {
	INSTANCE;

	private BitmapMemoryCache mBitmapMemoryCache;
	private ImageLoader mImageLoader;

	private ImageCacheManager() {

	}

	public void initImageCache() {

		mBitmapMemoryCache = new BitmapMemoryCache(getCacheSize());
		Log.i("Cache size:", "Cache size" + getCacheSize());

		mImageLoader = new ImageLoader(VolleyHelper.getImageRequestQueue(), mBitmapMemoryCache);
	}

	public ImageLoader getImageLoader() {
		return mImageLoader;
	}

	private int getCacheSize() {

		final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
		final int cacheSize = maxMemory / 8;
		return cacheSize;
	}

	public void evictAll() {
		if (mBitmapMemoryCache != null)
			mBitmapMemoryCache.evictAll();

	}

	public void remove(String key, int maxWidth, int maxHeight) {
		if (mBitmapMemoryCache != null)
			mBitmapMemoryCache.remove(getCacheKey(key, maxWidth, maxHeight));
	}

	private static String getCacheKey(String url, int maxWidth, int maxHeight) {
		return new StringBuilder(url.length() + 12).append("#W").append(maxWidth).append("#H").append(maxHeight)
				.append(url).toString();
	}

}
