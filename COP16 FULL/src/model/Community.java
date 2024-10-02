package model;

public class Community {

	private String name;
	private int numInhabitants;

	/**
	 * 
	 * @param name
	 * @param numInhabitants
	 * @param types
	 * @param problems
	 */
	public Community(String name, int numInhabitants, String types, String problems) {
		this.name = name;
		this.numInhabitants = numInhabitants;
	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getNumInhabitants() {
		return numInhabitants;
	}

	/**
	 * 
	 * @param numInhabitants
	 */
	public void setNumInhabitants(int numInhabitants) {
		this.numInhabitants = numInhabitants;
	}

	public String toString() {
		return "atriubutos" + "-" + name + "-" + numInhabitants;
	}

	public String getType() {
		// TODO - implement Community.getType
		throw new UnsupportedOperationException();
	}

	public String getProblem() {
		// TODO - implement Community.getProblem
		throw new UnsupportedOperationException();
	}

}