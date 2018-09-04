/*
 * Copyright (c) 2018.  John Hollowell (hollowe)
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.logging.Logger;

import format.Feed;


class JsonReader {

	public static final String langCode = "en";


	static String rootURL = "https://people.cs.clemson.edu/~hollowe/testing.json";

	public static String JsonReader() throws IOException {

		URLConnection request = new URL(rootURL).openConnection();
		request.connect();

		JsonElement root    = new JsonParser().parse(new InputStreamReader((InputStream) request.getContent()));
		JsonObject  rootobj = root.getAsJsonObject();
		String      zipcode = rootobj.get("data").getAsString(); //just grab the zipcode
		return zipcode;
	}

	public static JsonElement getJsonElementFromUrlString(String url) {

		try {
			URLConnection request = new URL(url).openConnection();
			request.connect();

			return new JsonParser().parse(new InputStreamReader((InputStream) request.getContent()));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static JsonElement getJsonElementFromUrl(URL url) {

		try {
			URLConnection request = url.openConnection();
			request.connect();

			return new JsonParser().parse(new InputStreamReader((InputStream) request.getContent()));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Map<String, Feed> fillFeeds(String gbfsLocation) throws MalformedURLException {
		JsonElement elem = getJsonElementFromUrlString(gbfsLocation);
		if (elem == null) throw new MalformedURLException();

		JsonArray jsonFeeds = elem.getAsJsonObject().getAsJsonObject("data").getAsJsonObject(langCode).getAsJsonArray("feeds");
		for (JsonElement feed : jsonFeeds){
			String url = feed.getAsJsonObject().getAsJsonPrimitive("url").getAsString();
			String name = feed.getAsJsonObject().getAsJsonPrimitive("name").getAsString();
			new Feed(name, url);
		}
		return Feed.getFeeds();
	}
}
