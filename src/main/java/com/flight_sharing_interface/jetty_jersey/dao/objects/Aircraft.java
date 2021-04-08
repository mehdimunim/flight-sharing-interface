package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aircraft {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	protected long id = 0;

	@Persistent(defaultFetchGroup = "true")
	protected List<Aircraft> aircrafts = null;

	protected int numberOfPlaces;
	protected String model;
	protected int flightHours;
	protected String owner;

	public Aircraft(String model) {
		super();
		this.model = model;
	}

	public Aircraft(long id, int numberOfPlaces, String model, int flightHours, String owner) {
		this.id = id;
		this.numberOfPlaces = numberOfPlaces;
		this.model = model;
		this.flightHours = flightHours;
		this.owner = owner;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumberOfPlaces() {
		return numberOfPlaces;
	}

	public void setNumberOfPlaces(int numberOfPlaces) {
		this.numberOfPlaces = numberOfPlaces;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getFlightHours() {
		return flightHours;
	}

	public void setFlightHours(int flightHours) {
		this.flightHours = flightHours;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Aircraft() {
		super();
		this.aircrafts = new ArrayList<Aircraft>();
	}

	public List<Aircraft> getAircrafts() {
		return aircrafts;
	}

	public void setAircrafts(List<Aircraft> aircrafts) {
		this.aircrafts = aircrafts;
	}

}