package model;

public class Route {

	private String name;
	private double temperature;
	private double humidity;
	private int numAttendants;
	private int numGuides;
	private int numBuses;

	/**
	 * 
	 * @param name
	 * @param temperature
	 * @param humidity
	 * @param numAttendats
	 * @param numGuides
	 * @param numBuses
	 * 
	 */
	public Route(String name, double temperature, double humidity, int numAttendats, int numGuides, int numBuses) {
		this.name = name;
		this.temperature = temperature;
		this.humidity = humidity;
		this.numAttendants = numAttendats;
		this.numGuides = numGuides;
		this.numBuses = numBuses;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public int getNumAttendants() {
		return numAttendants;
	}

	public void setNumAttendants(int numAttendants) {
		this.numAttendants = numAttendants;
	}

	public int getNumGuides() {
		return numGuides;
	}

	public void setNumGuides(int numGuides) {
		this.numGuides = numGuides;
	}

	public int getNumBuses() {
		return numBuses;
	}

	public void setNumBuses(int numBuses) {
		this.numBuses = numBuses;
	}

	public String toString() {
		return "atriubutos" + "-" + name + "-" + temperature + "-" + humidity + "-" + numAttendants + "-" + numGuides
				+ "-" + numBuses;
	}

}