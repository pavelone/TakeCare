package com.example.takecare;

import java.util.Calendar;

import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private TextView textCT;
	private TextView textConsult;
	private TextView textRead;
	private TextView textResults;
	private TextView textMessage;
	private TextView textMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textCT = (TextView) findViewById(R.id.textCT);
		textConsult = (TextView) findViewById(R.id.textConsult);
		textResults = (TextView) findViewById(R.id.textResults);
		textRead = (TextView) findViewById(R.id.textRead);
		textMessage = (TextView) findViewById(R.id.textMessage);
		textMap = (TextView) findViewById(R.id.textMap);
		
		textCT.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Toast.makeText(getApplicationContext(), "Schedule CT Study", Toast.LENGTH_SHORT).show();
				Calendar beginTime = Calendar.getInstance();
				beginTime.set(2014, 5, 19, 7, 30);
				Calendar endTime = Calendar.getInstance();
				endTime.set(2014, 5, 19, 8, 30);
				Intent intent = new Intent(Intent.ACTION_INSERT)
				        .setData(Events.CONTENT_URI)
				        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
				        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
				        .putExtra(Events.TITLE, "CT Scan")
				        .putExtra(Events.DESCRIPTION, "high-resolution CT study")
				        .putExtra(Events.EVENT_LOCATION, "Anschutz Cancer Center")
				        .putExtra(Events.AVAILABILITY, Events.AVAILABILITY_BUSY)
				        .putExtra(Intent.EXTRA_EMAIL, "ally.crighton@gmail.com, pavel.s.smirnov@gmail.com");
				startActivity(intent);
			}
		});

		textConsult.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Toast.makeText(getApplicationContext(), "Schedule Consult", Toast.LENGTH_SHORT).show();
				// A date-time specified in milliseconds since the epoch.
				long startMillis = 0;
				Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
				builder.appendPath("time");
				ContentUris.appendId(builder, startMillis);
				Intent intent = new Intent(Intent.ACTION_VIEW)
				    .setData(builder.build());
				startActivity(intent);
			}
		});
		
		textResults.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Toast.makeText(getApplicationContext(), "View test results", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(MainActivity.this, ViewTestResults.class);
				startActivity(intent);

			}
		});

		textRead.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Read consult notes", Toast.LENGTH_SHORT).show();
			}
		});

		textMessage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Text your physician", Toast.LENGTH_SHORT).show();
			}
		});

		textMap.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Toast.makeText(getApplicationContext(), "Map to the Anschutz Cancer Center", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(android.content.Intent.ACTION_VIEW, 
						Uri.parse("geo:39.7438401,-104.8385318,17"));
						startActivity(intent);
			}
		});

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}