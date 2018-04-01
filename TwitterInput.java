
package twitterInput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterInput {
 private static TwitterFactory tf;
    
    // default triState area geodata
    private static double GeoLat = 40.808611;
    private static double GeoLong = -74.020386;
    private static double rad = 45;

    
 // establishes authentication settings for Twitter
 private static void configure() {
  ConfigurationBuilder cb = new ConfigurationBuilder();
  
  cb.setDebugEnabled(true)
  	.setOAuthConsumerKey("eARCh8X5eBNtIbWU9yBUnwuBc")
  	.setOAuthConsumerSecret("4XsHBLBJJ3F1ANWjFqbG08mN5ambiET9gLTi3yOGfQ2wCSafEm")
  	.setOAuthAccessToken("931331480953020417-05CH76Sa5Cs9ecPSvMduvNJ8csoNhLE")
  	.setOAuthAccessTokenSecret("S2IXxdY5Vv0tC2ooB247dWtHrMDDdPDyKlZP3BSTZB7So");
  
  tf = new TwitterFactory(cb.build()); 
 }
 
 // searches tweets given a string input and returns a list of relevant ones
 private static List<String> searchtweets(String input, String pages) {
	 Twitter twitter = tf.getInstance();
	 final int numPages = Integer.parseInt(pages);
	 List<Status> tweets;
	 List<String> tweetTexts = new ArrayList<String>();
  
	 Query query = new Query(input);    
	 query.setGeoCode(new GeoLocation(GeoLat, GeoLong), rad, Query.MILES);
	 query.setLang("en"); 
	 query.setCount(100);
	 query.setResultType(Query.RECENT);
	 
     try {
    	 int i = 0;
         QueryResult result;
         do {
             result = twitter.search(query);
             tweets = result.getTweets();
             for (Status tweet : tweets) {
            	 if (!tweet.isRetweet())
            		 tweetTexts.add(tweet.getText()); 
             }
             i++;
         } while ((query = result.nextQuery()) != null && i < numPages);
     } catch (TwitterException te) {
         te.printStackTrace();
         System.out.println("Failed to search tweets: " + te.getMessage());
         System.exit(-1);
     }
	 
     return tweetTexts;
 }
 
 public static void geoSearch(String term, String count, double lat, double longi, double radius, int appendage) throws TwitterException, IOException {
	 configure();
	 
	 double GeoLat = lat;
	 double GeoLong = longi;
	 double rad = radius;
	 
	 List<String> tweetTexts = searchtweets(term, count);
	 
	 String filename = "parsedTweets.out";
	 if (appendage != -1)
		 filename = filename + appendage;
	 PrintWriter outFile = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
	 for (String s: tweetTexts) {
		 s.trim();
		 outFile.println(s);
	 	}
	 outFile.close();
 }
 	
public static void main (String[] args) throws TwitterException, IOException {
	String[] coordinates = args[1].split(",");
	geoSearch(args[0], "5", Double.parseDouble(coordinates[0].trim()), Double.parseDouble(coordinates[1].trim()), Double.parseDouble(args[2]), -1);
}
}