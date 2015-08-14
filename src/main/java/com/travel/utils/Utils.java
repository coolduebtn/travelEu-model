package com.travel.utils;

public class Utils {
	
	public static String generatePermalink(String title){
		
		String permalink = title.replaceAll("\\s", "_"); // whitespace becomes _
		permalink = permalink.replaceAll("\\W", ""); // get rid of non
														// alphanumeric
		permalink = permalink.toLowerCase();
		
		return permalink;
		
	}

}
