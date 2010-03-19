package com.jittr.foursquare;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.jittr.foursquare.BaseFeedParser;
import com.jittr.foursquare.FQFriendsAPI;
import com.jittr.foursquare.Message;


public class SaxFeedParser extends BaseFeedParser {

	    private FourSquareAPIs handlerType;
	    
		protected SaxFeedParser(FourSquareAPIs handlerType, String feedUrl){
			super(feedUrl);
			this.handlerType=handlerType;
		}
		@Override
		public List<Message> parse() {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			try {
				SAXParser parser = factory.newSAXParser();
				//FQFriendsAPI handler = new FQFriendsAPI();
				//FourSquareHandler handler = new FQFriendsAPI();
				FourSquareHandler handler = FourSquareParserType.getFourSquareParserType(handlerType);
				parser.parse(this.getInputStream(), handler);
				return handler.getMessages();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}  //catch
		} //parse
	}  //class

