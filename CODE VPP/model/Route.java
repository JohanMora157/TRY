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
	 * @param numBuses
	 */
	public Route(String name, double temperature, double humidity, int numAttendats, int numGuides, int numBuses) {
		// TODO - implement Route.Route
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param temperature
	 * @param humidity
	 */
	public String verifyClimate(double temperature, double humidity) {
		// TODO - implement Route.verifyClimate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numAttendants
	 * @param numGuides
	 */
	public int calculateBuses(int numAttendants, int numGuides) {
		// TODO - implement Route.calculateBuses
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		// TODO - implement Route.getName
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param temperature
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getTemperature() {
		// TODO - implement Route.getTemperature
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param humidity
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public String getHumidity() {
		// TODO - implement Route.getHumidity
		throw new UnsupportedOperationException();
	}

}