package com.demo.recylerview;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import com.demo.recylerview.R;

public class RecyclerHolder extends ViewHolder {

	public interface ViewType {

		int RED_BG = 0;
		int GREEN_BG = 1;
		int BLUE_BG = 2;

	}

	public TextView mRed;
	public TextView mGreen;
	public TextView mBlue;

	public RecyclerHolder(View itemView, int type) {
		super(itemView);

		switch (type) {
		case ViewType.RED_BG:
			mRed = (TextView) itemView.findViewById(R.id.red);
			break;
		case ViewType.GREEN_BG:
			mRed = (TextView) itemView.findViewById(R.id.green);
			break;
		case ViewType.BLUE_BG:
			mRed = (TextView) itemView.findViewById(R.id.blue);
			break;

		}

	}
	
	
	

}
