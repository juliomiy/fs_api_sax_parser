package com.jittr.foursquare;

import static com.jittr.foursquare.BaseFeedParser.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class FQFriendsAPI extends FourSquareHandler {
	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, name, attributes);
		if (localName.equalsIgnoreCase(FSUSER)){
			this.currentMessage = new Message();
		}
	}
	@Override
	public void endElement(String uri, String localName, String name)
			throws SAXException {
		super.endElement(uri, localName, name);
		if (this.currentMessage != null){
			if (localName.equalsIgnoreCase(FSFIRSTNAME)){
			   currentMessage.setFirstname(builder.toString());
			} else if (localName.equalsIgnoreCase(FSLASTNAME)){
				currentMessage.setLastname(builder.toString());
			} else if (localName.equalsIgnoreCase(FSID)){
				currentMessage.setId(builder.toString());
			} else if (localName.equalsIgnoreCase(FSEMAIL)){
				currentMessage.setEmail(builder.toString());
			} else if (localName.equalsIgnoreCase(FSUSER)){
				messages.add(currentMessage);
			}
			builder.setLength(0);	
		}
	}
}
