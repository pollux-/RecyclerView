package com.demo.recylerview;

import android.app.Application;

import com.demo.recylerview.cache.ImageCacheManager;
import com.demo.recylerview.io.VolleyHelper;

/**
 * @author sreekumar
 * 
 */
public class RecyclerApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		VolleyHelper.initQueues(this);
		ImageCacheManager.INSTANCE.initImageCache();

	}

}
