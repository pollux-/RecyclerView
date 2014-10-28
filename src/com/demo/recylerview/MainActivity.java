package com.demo.recylerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.demo.recylerview.R;

/**
 * @author sreekumar
 * 
 */

public class MainActivity extends Activity {

	private static final int COULMN_SIZE = 2;
	private LinearLayoutManager mLinearLayoutManager;
	private GridLayoutManager mGridLayoutManager;
	private RecyclerView mRecyclerView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mRecyclerView = (RecyclerView) findViewById(R.id.list);
		mRecyclerView.setHasFixedSize(true);
		mLinearLayoutManager = new LinearLayoutManager(this);

		mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		mRecyclerView.setLayoutManager(mLinearLayoutManager);
		mRecyclerView.setAdapter(new RecycleAdapter());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.vertical:
			mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
			mRecyclerView.setLayoutManager(mLinearLayoutManager);
			return true;

		case R.id.horizontal:
			mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
			mRecyclerView.setLayoutManager(mLinearLayoutManager);
			return true;

		case R.id.grid:
			if (mGridLayoutManager == null)
				mGridLayoutManager = new GridLayoutManager(this, COULMN_SIZE);
			mRecyclerView.setLayoutManager(mGridLayoutManager);
			return true;

		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}
}
