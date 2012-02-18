package com.waterloo.weather;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class Settings extends PreferenceActivity {

	private boolean updateAutomatically;
	
	@Override
	protected void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.settings);
		
	}
	
	@Override
	protected void onStart(){
		super.onStart();
		getPrefs();
	}
	
	public boolean isUpdatingAutomatically(){
		return updateAutomatically;
	}
	
	private void getPrefs(){
		SharedPreferences prefs = PreferenceManager
		.getDefaultSharedPreferences(getBaseContext());
		updateAutomatically = prefs.getBoolean("updatePref", true);
	}
}
