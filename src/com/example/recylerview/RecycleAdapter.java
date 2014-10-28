package com.example.recylerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recylerview.RecyclerHolder.ViewType;

public class RecycleAdapter extends RecyclerView.Adapter<RecyclerHolder> {

	@Override
	public int getItemCount() {
		return 100;
	}

	@Override
	public void onBindViewHolder(RecyclerHolder holder, int position) {

	}

	@Override
	public int getItemViewType(int position) {

		return position % 3;
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
