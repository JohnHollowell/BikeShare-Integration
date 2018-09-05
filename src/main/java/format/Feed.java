package format;
/*
 * Copyright (c) 2018.  John Hollowell (hollowe)
 */

import java.util.HashMap;
import java.util.Map;


/**
 * A data structure to contain the feed information for different feeds of data provided by the API
 *
 * @author John
 *
 */
public class Feed {
	private static Map<String, Feed> feeds = new HashMap<String, Feed>();

	private String name;
	private String url;

	/**
	 * Constructor stores the name and string representation of the URL.
	 * Adds feed to <code>feeds</code> map with key <code>name</code>.
	 *
	 * @param name the name of the feed
	 * @param url a string of the url where the feed is found
	 */
	public Feed(String name, String url) {
		this.name = name;
		this.url = url;
		feeds.put(name, this);
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public static Map<String, Feed> getFeeds() {
		return feeds;
	}

	public static void setFeeds(Map<String, Feed> feeds) {
		Feed.feeds = feeds;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Feed){
			return this.name.equals(((Feed)obj).name) &&
				   this.url.equals(((Feed)obj).url);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Feed " + name + " at " + url;
	}
}
