/*
 * Copyright (c) 2018.  John Hollowell (hollowe)
 */


import java.io.IOException;
import java.util.logging.Level;

import format.Feed;
import format.Station;
import static data.Variables.*;

class BikeShare {

	public static void main(String[] args){
		log.setLevel(Level.ALL);

		try {
			System.out.println(JsonReader.JsonReader());

			for (Feed f : JsonReader.fillFeeds(gbfsUrl).values()){
				log.fine("Feeds:");
				log.fine(f.getName() + " | " + f.getUrlStr());

			}


		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
