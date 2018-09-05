package data;

/*
 * Copyright (c) 2018.  John Hollowell (hollowe)
 */

import java.util.Locale;
import java.util.logging.Logger;

public class Variables {

	public static Logger logger = Logger.getLogger("BikeShare");

	/**
	 * The number of retries connections will attempt before failing.
	 */
	public static final int retryAttempts = 10;

	public static final Locale currentLocale = new Locale("en", "US");

}
