package com.jordanbang.musicdiff;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MusicDiffMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music_diff_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.music_diff_main, menu);
		return true;
	}

}
