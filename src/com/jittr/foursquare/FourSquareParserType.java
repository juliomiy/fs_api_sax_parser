package com.jittr.foursquare;

import com.jittr.foursquare.FourSquareAPIs;
//import static com.jittr.foursquare.BaseFeedParser.*;
public abstract class FourSquareParserType {

	public  static FourSquareHandler getFourSquareParserType(FourSquareAPIs handlerType) {
		switch (handlerType){
		   case FRIENDS:
			  return new FQFriendsAPI();
		  case USER:
		      return new FQUserAPI();
		//case ANDROID_SAX:
		//	return new AndroidSaxFeedParser(feedUrl);
		//case XML_PULL:
		//	return new XmlPullFeedParser(feedUrl);
		   default: return null;
	    } //switch
	}  //constructor
} //class
