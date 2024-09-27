
package model;

public class Place {

	private double economicResources;

	private String photoPlace;
	private date openingDate;
	private String name;
	private double area;
	private String department;

	/**
	 * 
	 * @param photoPlace
	 * @param openingDate
	 * @param economicResources
	 * @param openingDate
	 * @param area
	 * @param department
	 * 
	 */
	public Place(String photoPlace, date openingDate, double economicResources, String name, String department,
			double area) {

		this.photoPlace = photoPlace;
		this.openingDate = openingDate;
		this.economicResources = economicResources;
		this.name = name;
		this.department = department;
		this.area = area;
	}

	public date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(date openingDate) {
		this.openingDate = openingDate;
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

}