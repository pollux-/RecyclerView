package com.demo.recylerview;

import java.util.Random;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.demo.recylerview.RecyclerHolder.ViewType;
import com.demo.recylerview.cache.ImageCacheManager;
import com.demo.recylerview.utils.Images;

/**
 * @author sreekumar
 * 
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecyclerHolder> {

	private static final int TYPE_COUNT = 3;
	private static final int COUNT = 100;
	private ImageLoader mImageLoader;
	private Random mRandom;

	public RecycleAdapter() {
		mImageLoader = ImageCacheManager.INSTANCE.getImageLoader();
		mRandom = new Random();
	}

	@Override
	public int getItemCount() {
		return COUNT;
	}

	@Override
	public void onBindViewHolder(RecyclerHolder holder, int position) {

		switch (getItemViewType(position)) {
		case ViewType.RED_BG:
			setRedItem(holder, position);
			break;
		case ViewType.GREEN_BG:
			setGreenItem(holder, position);
			break;
		case ViewType.BLUE_BG:
			setBlueItem(holder, position);
			break;
		default:
			break;
		}

	}

	private void setRedItem(RecyclerHolder holder, int position) {
		holder.mRedHolder.mRed.setText("Position: " + position);
		holder.mRedHolder.mThumb.setImageUrl(Images.imageThumbUrls[mRandom.nextInt(Images.imageThumbUrls.length)],
				mImageLoader);
	}

	private void setBlueItem(RecyclerHolder holder, int position) {
		holder.mBlueHolder.mBlue.setText("Position: " + position);

		holder.mBlueHolder.mThumb.setImageUrl(Images.imageThumbUrls[mRandom.nextInt(Images.imageThumbUrls.length)],
				mImageLoader);
	}

	private void setGreenItem(RecyclerHolder holder, int position) {
		holder.mGreenHolder.mGreen.setText("Position: " + position);
		holder.mGreenHolder.mThumb.setImageUrl(Images.imageThumbUrls[mRandom.nextInt(Images.imageThumbUrls.length)],
				mImageLoader);
	}

	@Override
	public int getItemViewType(int position) {

		return position % TYPE_COUNT;
	}

	@Override
	public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		final View view;

		switch (viewType) {
		case ViewType.RED_BG:
			view = LayoutInflater.from(parent.getContext()).inflate(R.layout.red_bg_item, parent, false);
			break;
		case ViewType.GREEN_BG:
			view = LayoutInflater.from(parent.getContext()).inflate(R.layout.green_bg_item, parent, false);
			break;
		case ViewType.BLUE_BG:
			view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blue_bg_item, parent, false);
			break;
		default:
			view = null;

		}

		return new RecyclerHolder(view, viewType);
	}

}
