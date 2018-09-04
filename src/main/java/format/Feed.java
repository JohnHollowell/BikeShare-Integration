package format;
/*
 * Copyright (c) 2018.  John Hollowell (hollowe)
 */

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * A data structure to contain the feed information for different feeds of data provided by the GBFS API
 *
 * @author John
 * @
 */
public class Feed {
	private static Map<String, Feed> feeds = new HashMap<String, Feed>();

	private String name;
	private String urlStr;
	private URL    url;

	/**
	 * Constructor stores name and urlStr, as well as attempting to create a URL from urlStr.
	 * Adds feed to <code>feeds</code> map with key <code>name</code>
	 *
	 * @param name the name of the feed
	 * @param urlStr a string of the url where the feed is found
	 */
	public Feed(String name, String urlStr) throws MalformedURLException {
		this.name = name;
		this.urlStr = urlStr;
		this.url = new URL(urlStr);
		feeds.put(name, this);
	}

	public String getName() {
		return name;
	}

	public String getUrlStr() {
		return urlStr;
	}

	public URL getUrl() {
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
				   this.urlStr.equals(((Feed)obj).urlStr);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Feed " + name + " at " + urlStr;
	}
}
