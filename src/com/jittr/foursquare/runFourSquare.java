package com.jittr.foursquare;

import java.util.List;

public class runFourSquare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    
		  String friendsAPI = "http://juliomiyares.com/julio_blog/4qbasicauth.php";
		  SaxFeedParser parser = new SaxFeedParser(friendsAPI); 
          List<Message> messages = parser.parse();
          System.out.println("Hello World");
          System.out.println("Number of messages = " + messages.size());
          for (Message msg: messages ) {
        	  System.out.println(msg + "\n");
          }
	}
	

}
