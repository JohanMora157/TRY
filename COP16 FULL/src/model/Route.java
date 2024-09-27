package model;

public class Route {

	private String name;
	private double temperature;
	private double humidity;
	private int numAttendants;
	private int numGuides;

	/**
	 * 
	 * @param name
	 * @param temperature
	 * @param humidity
	 * @param numAttendats
	 * @param numGuides
	 * 
	 */
	public Route(String name, double temperature, double humidity, int numAttendats, int numGuides, int numBuses) {
		this.name = name;
		this.temperature = temperature;
		this.humidity = humidity;
		this.numAttendants = numAttendats;
		this.numGuides = numGuides;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param temperature
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getTemperature() {
		return temperature;
	}

	/**
	 * 
	 * @param humidity
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getHumidity() {
		return humidity;
	}

	/**
	 * 
	 * @param numAttendants
	 */
	public void setNumAttendants(int numAttendants) {
		this.numAttendants = numAttendants;
	}

	public int getNumAttendants() {
		return numAttendants;
	}

	/**
	 * 
	 * @param numGuides
	 */
	public void setNumGuides(int numGuides) {
		this.numGuides = numGuides;
	}

	public int getNumGuides() {
		return numGuides;
	}
}