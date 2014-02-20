package com.example.takecare;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class ViewTestResults extends Activity {

	protected static final String EXTRA_RES_ID = "POS";
	
	private ArrayList<Integer> mThumbIdsPictures = new ArrayList<Integer>(
			Arrays.asList(R.drawable.image1, R.drawable.image2));

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_results);

		GridView gridview = (GridView) findViewById(R.id.gridview);

		gridview.setAdapter(new ImageAdapter(this, mThumbIdsPictures));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Intent intent = new Intent(ViewTestResults.this,
						ImageViewActivity.class);
				intent.putExtra(EXTRA_RES_ID, (int) id);
				startActivity(intent);
			}
		});
	}

	
}
