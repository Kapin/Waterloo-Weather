package com.kapin.xml;

import java.util.ArrayList;
import java.util.List;


import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Xml;

public class AndroidSaxFeedParser extends BaseFeedParser {

	public AndroidSaxFeedParser(String feedUrl){
		super(feedUrl);
	}
	
	@Override
	public List <String> parse() {
		//final Message currentMessage = new Message();
		RootElement root = new RootElement(CURRENT_OBSERVATION);
		final List<String> messages = new ArrayList<String>(100);
		//Element root = root.getChild(CURRENT_OBSERVATION);
		//Element description = item.getChild(DESCRIPTION);
		/*root.setEndElementListener(new EndElementListener(){
			public void end(){
				messages.add(currentMessage.copy());
			}
		});*/
		root.getChild(CREDIT).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(CREDIT_URL).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(SUGGESTED_PICKUP).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(SUGGESTED_PICKUP_PERIOD).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(LOCATION).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(LATITUDE).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(LONGITUDE).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(ELEVATION).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(OBSERVATION_MONTH_TEXT).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(OBSERVATION_MONTH_NUMBER).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(OBSERVATION_DAY).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(OBSERVATION_YEAR).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(OBSERVATION_TIME).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(OBSERVATION_HOUR).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(OBSERVATION_MINUTE).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(TEMPERATURE_CURRENT_C).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(HUMIDEX_C).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(WINDCHILL_C).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(TEMPERATURE_24HRMAX_C).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(TEMPERATURE_24HRMIN_C).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(PRECIPITATION_15MINUTES_MM).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(PRECIPITATION_1HR_MM).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(PRECIPITATION_24HR_MM).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(RELATIVE_HUMIDITY_PERCENT).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(DEW_POINT_C).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(WIND_SPEED_KPH).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(WIND_DIRECTION).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(WIND_DIRECTION_DEGREES).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(PRESSURE_KPA).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(PRESSUE_TREND).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		root.getChild(INCOMING_SHORTWAVE_RADIATION_WM2).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body){
				messages.add(body);
			}
		});
		
        try{
        	Xml.parse(this.getInputStream(), Xml.Encoding.UTF_8,
        			root.getContentHandler());
        } catch (Exception e) {        	
        	throw new RuntimeException(e);
        } 
        return messages;
	}
}