package model;

public class Community {

	private String name;
	private int numInhabitants;
	private String type;
	private Representative representative;
	private String[] problemsCommunity;

	public Community(String name, int numInhabitants, String type) {// , String types, String problems
		this.name = name;
		this.numInhabitants = numInhabitants;
		this.type = type;
		this.problemsCommunity = new String[4];

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumInhabitants() {
		return numInhabitants;
	}

	public void setNumInhabitants(int numInhabitants) {
		this.numInhabitants = numInhabitants;
	}

	public String toString() {
		return "atriubutos" + "-" + name + "-" + numInhabitants;
	}

	public Representative getRepresentative() {
		return representative;
	}

	public String[] getProblemsCommunity() {
		return problemsCommunity;
	}

	public void setProblemsCommunity(String[] problemsCommunity) {
		this.problemsCommunity = problemsCommunity;
	}

	public boolean addRepresentative(Representative newRepresentative) {

		if (representative == null) {
			representative = newRepresentative;

			return true;
		}

		return false;
	}

}