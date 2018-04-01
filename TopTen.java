package geotrends;

import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.api.TrendsResources;
import twitter4j.conf.ConfigurationBuilder;

public class TopTen {
	
	private static TwitterFactory tf;
	
	private static void configure() {
		  ConfigurationBuilder cb = new ConfigurationBuilder();
		  
		  cb.setDebugEnabled(true)
		  	.setOAuthConsumerKey("eARCh8X5eBNtIbWU9yBUnwuBc")
		  	.setOAuthConsumerSecret("4XsHBLBJJ3F1ANWjFqbG08mN5ambiET9gLTi3yOGfQ2wCSafEm")
		  	.setOAuthAccessToken("931331480953020417-05CH76Sa5Cs9ecPSvMduvNJ8csoNhLE")
		  	.setOAuthAccessTokenSecret("S2IXxdY5Vv0tC2ooB247dWtHrMDDdPDyKlZP3BSTZB7So");
		  
		  tf = new TwitterFactory(cb.build()); 
		 }
	
	public static void main(String[] args) throws TwitterException {
		configure();
		
		Twitter twitter = tf.getInstance();
		
		int woeid; 
		switch(args[0]) {
			// New York City
			case "0":
				woeid = 2459115;
				break;
			// Los Angeles
			case "1":
				woeid = 2442047;
				break;
			// Chicago
			case "2":
				woeid = 2379574;
				break;
			// Houston
			case "3":
				woeid = 2424766;
				break;
			// Philadelphia
			case "4":
				woeid = 2471217;
				break;	
			// Phoenix
			case "5":
				woeid = 2471390;
				break;
			// San Antonio
			case "6":
				woeid = 2487796;
				break;
			// San Diego
			case "7":
				woeid = 2487889;
				break;
			// Dallas
			case "8":
				woeid = 2388929;
				break;
			// San Jose
			case "9":
				woeid = 2488042;
				break;
			// New York City
			default: 
				woeid = 2459115;
		}
		
		TrendsResources trends = twitter.trends();
		Trends placeTrends = trends.getPlaceTrends(woeid);
		Trend[] top = placeTrends.getTrends();
		
		for (int i = 0; i < 10; i++)
			System.out.println(top[i].getName());
	}

}
