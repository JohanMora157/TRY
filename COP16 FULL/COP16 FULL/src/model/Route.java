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
	 * 
	 */
	public Route(String name, double temperature, double humidity, int numAttendats, int numGuides) {
		this.name = name;
		this.temperature = temperature;
		this.humidity = humidity;
		this.numAttendants = numAttendats;
		this.numGuides = numGuides;
	 

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

 

	public String toString() {
		return "atriubutos" + "-" + name + "-" + numAttendants + "-" + numGuides
				 ;
	}

	
    public int calcular_buses() {
        int totalBuses;
		int totalPersonas = numAttendants+numGuides;

        if (totalPersonas % 25 == 0) {

            totalBuses = totalPersonas / 25;

        } else {

            totalBuses = 1 + (totalPersonas / 25);
        }
        return totalBuses;

    }

    public boolean calcular_clima() {

        if ((temperature >= 20 && temperature <= 25) && (humidity <= 60 && humidity >= 40)) {
            return true;

        } else {
            return false;

        }

    }

}