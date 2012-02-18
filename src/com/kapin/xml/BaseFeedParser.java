package com.kapin.xml;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseFeedParser implements FeedParser {

	//names for XML tags
	static final String CURRENT_OBSERVATION = "current_observation";
	static final String CREDIT = "credit";
	static final String CREDIT_URL = "credit_URL";
	static final String SUGGESTED_PICKUP = "suggested_pickup";
	static final String SUGGESTED_PICKUP_PERIOD = "suggested_pickup_period";
	static final String LOCATION = "location";
	static final String LATITUDE = "latitude";
	static final String LONGITUDE = "longitude";
	static final String ELEVATION="elevation";
	static final String OBSERVATION_MONTH_TEXT="observation_month_text";
	static final String OBSERVATION_MONTH_NUMBER="observation_month_number";
	static final String OBSERVATION_DAY="observation_day";
	static final String OBSERVATION_YEAR="observation_year";
	static final String OBSERVATION_TIME="observation_time";
	static final String OBSERVATION_HOUR="observation_hour";
	static final String OBSERVATION_MINUTE="observation_minute";
	static final String TEMPERATURE_CURRENT_C="temperature_current_C";
	static final String HUMIDEX_C="humidex_C";
	static final String WINDCHILL_C="windchill_C";
	static final String TEMPERATURE_24HRMAX_C="temperature_24hrmax_C";
	static final String TEMPERATURE_24HRMIN_C="temperature_24hrmin_C";
	static final String PRECIPITATION_15MINUTES_MM="precipitation_15minutes_mm";
	static final String PRECIPITATION_1HR_MM="precipitation_1hr_mm";
	static final String PRECIPITATION_24HR_MM="precipitation_24hr_mm";
	static final String RELATIVE_HUMIDITY_PERCENT="relative_humidity_percent";
	static final String DEW_POINT_C="dew_point_C";
	static final String WIND_SPEED_KPH="wind_speed_kph";
	static final String WIND_DIRECTION="wind_direction";
	static final String WIND_DIRECTION_DEGREES="wind_direction_degrees";
	static final String PRESSURE_KPA="pressure_kpa";
	static final String PRESSUE_TREND="pressuire_trend";
	static final String INCOMING_SHORTWAVE_RADIATION_WM2="incoming_shortwave_radiation_WM2";
	
	final URL feedUrl;
	
	protected BaseFeedParser(String feedUrl){
		try{
			this.feedUrl = new URL (feedUrl); 
		}catch(MalformedURLException e){
			throw new RuntimeException(e);
		}
	}
	
	protected InputStream getInputStream(){
		try{
			return feedUrl.openConnection().getInputStream();
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}
}
