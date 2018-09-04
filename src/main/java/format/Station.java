package format;
/*
 * Copyright (c) 2018.  John Hollowell (hollowe)
 */


import org.jetbrains.annotations.NotNull;

public class Station {
	private String name;
	private String id;
	private double lat;
	private double lon;
	private String address;
	private int    bikes;
	private int    docks;

	public Station(String name, String id, double lat, double lon, String address, int bikes, int docks) {
		this(name, id, lat, lon, address);
		this.bikes = bikes;
		this.docks = docks;
	}

	public Station(String name, String id, double lat, double lon, String address) {
		this.name = name;
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.address = address;
	}

	public Station(@NotNull Station stat) {
		this(stat.name, stat.id, stat.lat, stat.lon, stat.address, stat.bikes, stat.docks);
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

	public String getAddress() {
		return address;
	}

	public int getBikes() {
		return bikes;
	}

	public void setBikes(int bikes) {
		this.bikes = bikes;
	}

	public int getDocks() {
		return docks;
	}

	public void setDocks(int docks) {
		this.docks = docks;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Station) {

			return this.name.equals(((Station) obj).name) &&
				   this.id.equals(((Station) obj).id) &&
				   this.address.equals(((Station) obj).address) &&
				   this.bikes == ((Station) obj).bikes &&
				   this.docks == ((Station) obj).docks &&
				   (this.lat - ((Station) obj).lat) < 0.000001 &&
				   (this.lon - ((Station) obj).lon) < 0.000001;
		}
		return false;

	}


	@Override
	public String toString() {
		return id;
	}
}
