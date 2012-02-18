package com.kapin.xml;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Message implements Comparable<Message> {
	static SimpleDateFormat formatter = 
		new SimpleDateFormat ("dd MMM yyy HH:mm:ss");
	private String title;
	private URL link;
	private String description;
	private Date date;
	
	
	 //Classes from here until specified on are the various getters/setter
	 
	public void setTitle(String newTitle){
		title = newTitle.trim();
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setLink (String link){
		try{
			this.link = new URL (link);
		}catch (MalformedURLException e){
			throw new RuntimeException(e);
		}
	}
	
	public URL getLink (){
		return link;
	}
	
	public void setDescription(String newDescription){
		description = newDescription.trim();
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDate(String newDate){
		//pad the date if needed
		/*newDate = newDate.trim();
		while(!newDate.substring(20).endsWith("00")){
			newDate += "0";
		}*/
		try{
			date = formatter.parse(newDate.trim());
		} catch (ParseException e){
			throw new RuntimeException(e);
		}
	}
	
	public String getDate(){
		return formatter.format(this.date);
	}
	
	public Message copy(){
		Message copy = new Message();
		copy.title = title;
		copy.link=link;
		copy.description = description;
		copy.date = date;
		return copy;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Title: ");
		sb.append(title);
		sb.append('\n');
		sb.append("Date: ");
		sb.append(this.getDate());
		sb.append('\n');
		sb.append("Link: ");
		sb.append(link);
		sb.append('\n');
		sb.append("Description: ");
		sb.append(description);
		return sb.toString();
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result =1;
		result = prime*result +((date==null) ? 0 : date.hashCode());
		result = prime*result + 
			((description == null) ? 0: description.hashCode());
		result = prime*result + ((link ==null) ? 0 : link.hashCode());
		result = prime*result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if(date == null){
			if(other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if(description == null) {
			if(other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if(link == null){
			if(other.title != null)
					return false;
		} else if (title == null) {
			if(other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	//sort by date
	@Override
	public int compareTo(Message another) {
		if(another == null)
			return 1;
		//sort descending most recent first
		return another.date.compareTo(date);
	}
}
