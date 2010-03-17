package com.jittr.foursquare;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.jittr.foursquare.BaseFeedParser;
import com.jittr.foursquare.FQFriendsAPI;
import com.jittr.foursquare.Message;


public class SaxFeedParser extends BaseFeedParser {

		protected SaxFeedParser(String feedUrl){
			super(feedUrl);
		}
		@Override
		public List<Message> parse() {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			try {
				SAXParser parser = factory.newSAXParser();
				FQFriendsAPI handler = new FQFriendsAPI();
				parser.parse(this.getInputStream(), handler);
				return handler.getMessages();
			} catch (Exception e) {
				throw new RuntimeException(e);
			} 
		}
	}

