package data;

/*
 * Copyright (c) 2018.  John Hollowell (hollowe)
 */

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static data.Variables.currentLocale;

public class Localizer {

	/*
	For now, localization will just happen with a map. At some point,
	it will pull in localization from files based on local settings.
	 */

	private static Map<String, String> en_US = new HashMap<String, String>();

	public static String getLocalizedString(String label) {
		return getLocalizedString(currentLocale, label);
	}

	public static String getLocalizedString(Locale locale, String label) {
		if (locale == new Locale("en", "US")) {
			return en_US.getOrDefault(label, "localization.not_found");
		}
		return "localization.not_found";
	}

	public static void addLocalization(String label, String text) {
		addLocalization(currentLocale, label, text);
	}

	public static void addLocalization(Locale locale, String label, String text) {
		if (locale == new Locale("en", "US")) {
			en_US.put(label, text);
		}
	}

	public Localizer() {
		en_US.put("rootUrl.malformed", "rootUrl is malformed");

		//In the future, here is where files will be ingested
	}
}
