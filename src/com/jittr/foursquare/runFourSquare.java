package com.jittr.foursquare;

import java.util.List;
import com.jittr.foursquare.FourSquareAPIs;

public class runFourSquare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    
		  String friendsAPI = "http://juliomiyares.com/julio_blog/4qbasicauth.php";
		  SaxFeedParser parser = new SaxFeedParser(FourSquareAPIs.FRIENDS,friendsAPI); 
          List<Message> messages = parser.parse();
         // System.out.println("Hello World");
         // System.out.println("Number of messages = " + messages.size());
         /* for (Message msg: messages ) {
        	  System.out.println(msg + "\n");
          }*/
          String userAPI = "http://juliomiyares.com/julio_blog/4qgetuser.php";
          parser = new SaxFeedParser(FourSquareAPIs.USER,userAPI);
          messages = parser.parse();
          for (Message msg: messages ) {
        	  System.out.println(msg + "\n");
          }
	}
	

}
