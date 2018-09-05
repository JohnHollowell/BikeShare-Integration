package hooks;

/*
 * Copyright (c) 2018.  John Hollowell (hollowe)
 */

import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import data.Localizer;
import format.Feed;
import format.Station;

import static data.Variables.logger;

/**
 * An interface for all data providers.
 *
 * @author John
 */
interface IBikeShare {

	/**
	 * A map of all stations this service provides.
	 * Key: Station id
	 * Value: {@link Station}
	 */
	Map<String, Station> stations = new HashMap<String, Station>();

	/**
	 * A map of all feeds this service provides.
	 * Key: Feed name
	 * Value: {@link Feed}
	 */
	Map<String, Feed> feeds = new HashMap<String, Feed>();

	/**
	 * The url to the root file. This may be the only file, or may be a file
	 * defining the location of other feeds of information.
	 */
	String rootUrl = "";


	/**
	 * Returns the url (as a String) of the root feed provided by the service.
	 *
	 * @return the url of the root feed of the service
	 */
	default String getRootUrl() {
		return rootUrl;
	}

	/**
	 * A function which should be filled with localizations.
	 * This method is called when adding the service, before anything else.
	 *
	 */
	static void addLocalizations(){
		Localizer.addLocalization("provider.<YOUR SERVICE>.name","<YOUR NAME>");
	}

	/**
	 * Returns the {@link Station} which has the name provided
	 *
	 * @param name the name of the requested station
	 * @return the <code>Station</code> from this service whose name matches the input
	 */
	default Station getStationByName(String name) {
		for (Station stat : stations.values()) {
			if (stat.getName().equals(name)) return stat;
		}
		return null;
	}

	/**
	 * Returns the {@link Station} which has the id provided
	 *
	 * @param id the id of the requested station
	 * @return the <code>Station</code> from this service whose id matches the input
	 */
	default Station getStationById(String id) {
		return stations.get(id);
	}

	/**
	 * Connects to <code>rootUrl</code> and updates feed information
	 */
	default void updateFeeds() {
		/* DEBUG not working/tested yet */
		try {
			URLConnection request = new URL(rootUrl).openConnection();
			request.connect();

			new JsonParser().parse(new InputStreamReader((InputStream) request.getContent()));
		} catch (MalformedURLException e) {
			logger.severe(Localizer.getLocalizedString("rootUrl.malformed"));
		} catch (IOException e) {
			logger.warning(e.toString());
		}
	}

	/**
	 * connects to feed url and updates <code>stations</code> with current data
	 *
	 * @param stationFeed {@link Feed} with data about station status
	 */
	void updateStations(Feed stationFeed);


}
