/*
 * Copyright (c) 2018.  John Hollowell (hollowe)
 */


import java.io.IOException;
import java.util.logging.Level;

import format.Feed;

import static data.Variables.logger;

class BikeShare {

	public static void main(String[] args){
		logger.setLevel(Level.ALL);

		try {
			System.out.println(JsonReader.JsonReader());

			for (Feed f : JsonReader.fillFeeds("https://gbfs.bcycle.com/bcycle_clemson/gbfs.json").values()){
				logger.fine("Feeds:");
				logger.fine(f.getName() + " | " + f.getUrl());

			}


		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
