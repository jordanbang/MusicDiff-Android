package com.jordanbang.musicdiff;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MusicDiffMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music_diff_main);
		
		ListView list = (ListView) findViewById(R.id.music_list);
		
		String[] proj = {MediaStore.Audio.Media._ID,
		        MediaStore.Audio.Media.ARTIST,
		        MediaStore.Audio.Media.TITLE,
		        MediaStore.Audio.Media.DATA,
		        MediaStore.Audio.Media.DISPLAY_NAME,
		        MediaStore.Audio.Media.DURATION,
		        MediaStore.Audio.Media.ALBUM,
		        MediaStore.Audio.Media.IS_MUSIC,
		        MediaStore.Audio.Media.TRACK};
		
		String sortOrder = MediaStore.Audio.Media.ARTIST + " ASC, " + MediaStore.Audio.Media.ALBUM + " ASC, " + MediaStore.Audio.Media.TRACK + " ASC";
		@SuppressWarnings("deprecation")
		Cursor music = managedQuery(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, proj, MediaStore.Audio.Media.IS_MUSIC + " <> 0", null, sortOrder);
		
		String[] projection = {MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.ALBUM};
		int[] ids = {R.id.list_item_title, R.id.list_item_artist, R.id.list_item_album};
		list.setAdapter(new SimpleCursorAdapter(this, R.layout.music_list_item, music, projection, ids, 0));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.music_diff_main, menu);
		return true;
	}	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
		case R.id.action_info:
			createInfoDialog();
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void createInfoDialog() {
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle(R.string.welcome);
		alert.setMessage(R.string.welcome_msg);
		alert.show();
	}
}
