package com.waterloo.weather;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.kapin.xml.*;

public class WeatherActivity extends Activity {
	
	private final String URL = 
		"http://weather.uwaterloo.ca/waterloo_weather_station_data.xml";
	private List <String> data;
	private TextView title, temperature, precipHour, precipDay, humidity,
		pressure, windSpeed, updated;
	//private Settings setting;
	/*private AlarmManager updater;
	private Calendar updateTime;
	private BroadcastReceiver updateReceiver;*/
	static final int NO_INTERNET_ID = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
               
        initTextFields();        
        //initUpdater();        
    }
    
    @Override
    public void onResume(){
    	super.onResume();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	//Handle item selection
    	switch(item.getItemId()){
    	case R.id.update:
    		getRssFeed();
    		initTextFields();
    		return true;
    	case R.id.settings:
    		openSettings();
    		return true;
    	default:
    		return super.onOptionsItemSelected(item);
    	}
    }
    
    protected Dialog onCreateDialog(int id){
    	Dialog dialog;
    	switch(id){
    	case NO_INTERNET_ID:
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setMessage("No Internet connection available")
    				.setCancelable(false)
    				.setNeutralButton("Exit", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							WeatherActivity.this.finish();
						}
					});
    		dialog = builder.create();
    		break;
    	default:
    		dialog=null;
    	}
    	return dialog;
    }
    
    /*private void initUpdater(){
    	setting = new Settings();
    	
    	updateReceiver = new BroadcastReceiver(){
    		@Override
    		public void onReceive(Context context, Intent intent){
    			getRssFeed();
    			initTextFields();
    		}
    	};
    	registerReceiver(updateReceiver, new IntentFilter("UPDATE"));
    	
    	updater = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        updateTime = new GregorianCalendar();
        updateTime.set(Calendar.MINUTE,5);
        
        updater.setRepeating(AlarmManager.ELAPSED_REALTIME, updateTime.get(Calendar.MINUTE), 
        		AlarmManager.INTERVAL_FIFTEEN_MINUTES, null);
        
        
    }*/
    
    private void openSettings(){
    	Intent settingsActivity = new Intent(getBaseContext(), Settings.class);
    	startActivity(settingsActivity);
    }
    
    private void initTextFields(){
    	getRssFeed();
    	
    	title = (TextView)findViewById(R.id.title);
    	title.setText("University of Waterloo");
    	temperature = (TextView)findViewById(R.id.temp);
    	temperature.setText(""+data.get(Constants.TEMPERATURE_CURRENT_C).trim()+"°C");
    	precipHour = (TextView)findViewById(R.id.precip1);
    	precipHour.setText("Precipitation in the last hour: "+data.get(Constants.PRECIPITATION_1HR_MM).trim()+" mm");    	
    	precipDay = (TextView)findViewById(R.id.precip2);
    	precipDay.setText("Precipitation in the last 24 hours: "+data.get(Constants.PRECIPITATION_24HR_MM).trim()+" mm");
    	humidity = (TextView)findViewById(R.id.humidity);
    	humidity.setText("Relative humidity: "+data.get(Constants.RELATIVE_HUMIDITY_PERCENT).trim()+"%");
    	pressure = (TextView)findViewById(R.id.pressure);
    	pressure.setText("Pressure: "+data.get(Constants.PRESSURE_KPA).trim()+" kpa");
    	windSpeed = (TextView)findViewById(R.id.wind);
    	windSpeed.setText("Wind Speed: "+data.get(Constants.WIND_SPEED_KPH).trim()+" km/h, "+data.get(Constants.WIND_DIRECTION).trim());
    	updated = (TextView)findViewById(R.id.update);
    	updated.setText(data.get(Constants.OBSERVATION_TIME)+" EST, "+data.get(Constants.OBSERVATION_MONTH_TEXT).trim()+ " "+
    			data.get(Constants.OBSERVATION_DAY).trim()+", "+data.get(Constants.OBSERVATION_YEAR).trim());
    }
    
    
    private void getRssFeed(){
    	try{
    	AndroidSaxFeedParser rssParse = new AndroidSaxFeedParser (URL);
    	data = rssParse.parse();
    	}
    	catch(Exception e){
    		showDialog(NO_INTERNET_ID);
    	}
    	
    }
}