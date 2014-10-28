package com.demo.recylerview;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.demo.recylerview.R;

/**
 * @author sreekumar
 * 
 */
public class RecyclerHolder extends ViewHolder {

	public RedHolder mRedHolder;
	public GreenHolder mGreenHolder;
	public BlueHolder mBlueHolder;

	public interface ViewType {

		int RED_BG = 0;
		int GREEN_BG = 1;
		int BLUE_BG = 2;

	}

	public RecyclerHolder(View itemView, int type) {
		super(itemView);

		switch (type) {
		case ViewType.RED_BG:
			setRedSection(itemView);
			break;
		case ViewType.GREEN_BG:
			setGreenSection(itemView);
			break;
		case ViewType.BLUE_BG:
			setBlueSection(itemView);
			break;

		}

	}

	private void setBlueSection(View itemView) {

		mBlueHolder = new BlueHolder();
		mBlueHolder.mBlue = (TextView) itemView.findViewById(R.id.blue);
		mBlueHolder.mThumb = (NetworkImageView) itemView.findViewById(R.id.blue_thumb);

	}

	private void setGreenSection(View itemView) {

		mGreenHolder = new GreenHolder();
		mGreenHolder.mGreen = (TextView) itemView.findViewById(R.id.green);
		mGreenHolder.mThumb = (NetworkImageView) itemView.findViewById(R.id.green_thumb);
	}

	private void setRedSection(View itemView) {
		mRedHolder = new RedHolder();
		mRedHolder.mRed = (TextView) itemView.findViewById(R.id.red);
		mRedHolder.mThumb = (NetworkImageView) itemView.findViewById(R.id.red_thumb);

	}

	static class RedHolder {

		public TextView mRed;
		public NetworkImageView mThumb;

	}

	static class GreenHolder {

		public TextView mGreen;
		public NetworkImageView mThumb;

	}

	static class BlueHolder {

		public TextView mBlue;
		public NetworkImageView mThumb;

	}

}
