
package model;

public class Place {

	private double economicResources;
	private String photoPlace;
	private String name;
	private double area;
	private String department;
	private Specie[] species;
	private Community communitie;

	/**
	 * 
	 * @param photoPlace
	 * @param openingDate
	 * @param economicResources
	 * 
	 * @param area
	 * @param department
	 * 
	 */
	public Place(String photoPlace, double economicResources, String name, String department,
			double area) {

		this.photoPlace = photoPlace;
		this.economicResources = economicResources;
		this.name = name;
		this.department = department;
		this.area = area;
		this.species = new Specie[50];

	}

	public String getPhotoPlace() {
		return photoPlace;
	}

	/**
	 * 
	 * @param photoPlace
	 */
	public void setPhotoPlace(String photoPlace) {
		this.photoPlace = photoPlace;
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
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	/**
	 * 
	 * @param area
	 */
	public void setArea(double area) {
		this.area = area;
	}

	public double getArea() {
		return area;
	}

	/**
	 * 
	 * @param economicResources
	 */
	public void setEconomicResources(double economicResources) {
		this.economicResources = economicResources;
	}

	public double getEconomicResources() {
		return economicResources;
	}

	public String toString() {
		return "atriubutos" + "-" + economicResources + "-" + name + "-" + department + "-" + area + "-" + photoPlace
				+ "-" + species[0] + "-" + species[1];
	}

	public Specie[] getSpecies() {
		return species;
	}

	public boolean addSpecies(Specie newSpecies) {

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = newSpecies;
				return true;
			}
		}
		return false;
	}

	public Community getCommunities() {
		return communitie;
	}

	public boolean addCommunities(Community newCommunitie) {

		if (communitie == null) {

			communitie = newCommunitie;
			return true;

		}
		return false;
	}

}