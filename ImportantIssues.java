package geotrends;

import twitterInput.TwitterInput;

import java.io.IOException;

import twitter4j.TwitterException;
import twitter4j.conf.ConfigurationBuilder;

public class ImportantIssues {
	private static String[] queries = {"abortion", "gun control", "North Korea", "Donald Trump", "Russia"};
	
	private static void configure() {
		  ConfigurationBuilder cb = new ConfigurationBuilder();
		  
		  cb.setDebugEnabled(true)
		  	.setOAuthConsumerKey("eARCh8X5eBNtIbWU9yBUnwuBc")
		  	.setOAuthConsumerSecret("4XsHBLBJJ3F1ANWjFqbG08mN5ambiET9gLTi3yOGfQ2wCSafEm")
		  	.setOAuthAccessToken("931331480953020417-05CH76Sa5Cs9ecPSvMduvNJ8csoNhLE")
		  	.setOAuthAccessTokenSecret("S2IXxdY5Vv0tC2ooB247dWtHrMDDdPDyKlZP3BSTZB7So");
	}
	

	 public static void main(String[] args) throws TwitterException, IOException {
		 configure();
		 int query = Integer.parseInt(args[0]);
		 String q = queries[query];
		 
		 int i = 0;
		 while (i < 10) {
			 produceCityData(i, q);
		 }
	 }

	
	private static void produceCityData(int city_identifier, String query) throws TwitterException, IOException {		
		double lat, lon; 
		switch(city_identifier) {
			// New York City
			case 0:
				lat = 40.7128;
				lon = 74.0060;
				break;
			// Los Angeles
			case 1:
				lat = 34.0522;
				lon = 118.2437;
				break;
			// Chicago
			case 2:
				lat = 41.8781;
				lon = 87.6298;
				break;
			// Houston
			case 3:
				lat = 29.7604;
				lon = 95.3698;
				break;
			// Philadelphia
			case 4:
				lat = 39.9526;
				lon = 75.1652;
				break;	
			// Phoenix
			case 5:
				lat = 33.4484;
				lon = 112.0740;
				break;
			// San Antonio
			case 6:
				lat = 29.4241;
				lon = 98.4936;
				break;
			// San Diego
			case 7:
				lat = 32.7157;
				lon = 117.1611;
				break;
			// Dallas
			case 8:
				lat = 32.7767;
				lon = 96.7970;
				break;
			// San Jose
			case 9:
				lat = 37.3382;
				lon = 121.8863;
				break;
			// New York City
			default: 
				lat = 40.7128;
				lon = 74.0060;
		}
		
		TwitterInput.geoSearch(query, "5", lat, lon, 40.0, city_identifier);
	}
}
