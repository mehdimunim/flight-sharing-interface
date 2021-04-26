package com.flight_sharing_interface.jetty_jersey.dao.objects;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 
 * An aircraft is an aggregate of attribute that will be used for defining
 * flights (1 - n relationship)
 *
 */

@PersistenceCapable
public class Aircraft {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	protected long AircraftId = 0;

	// Aircraft Information
	private String model;
	private String owner;
	private int numberOfPlaces;

	// Defining children seems to be useful for postman
	@Persistent(defaultFetchGroup = "true")
	protected List<Aircraft> aircrafts = null;

	public Aircraft(String model, String owner, int numberOfPlaces) {
		this.model = model;
		this.owner = owner;
		this.numberOfPlaces = numberOfPlaces;
	}

	public Aircraft(long id, int numberOfPlaces, String model, int flightHours, String owner) {
		this.AircraftId = id;
		this.numberOfPlaces = numberOfPlaces;
		this.model = model;
		this.owner = owner;
	}

	public long getId() {
		return AircraftId;
	}

	public void setId(long id) {
		this.AircraftId = id;
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