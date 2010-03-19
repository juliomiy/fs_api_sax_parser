package com.jittr.foursquare;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseFeedParser implements FeedParser {
	private final URL feedUrl;
	static final String FSID="id";
    static final String FSUSER="user";
    static final String FSFIRSTNAME="firstname";
    static final String FSLASTNAME="lastname";
    static final String FSPHOTO="photo";
    static final String FSEMAIL="email";
    static final String FSTWITTER = "twitter";
    static final String FSFACEBOOK = "facebook";
    //static final int FSFRIENDSAPI=0;
    //static final int FSUSERAPI=1;
    
	protected BaseFeedParser(String feedUrl){
		try {
			this.feedUrl = new URL(feedUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	protected InputStream getInputStream() {
		try {
			return feedUrl.openConnection().getInputStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

} //class

