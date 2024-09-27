
package model;

public class Species {

	private String name;
	private int amount;
	private String photoSpecie;

	/**
	 * 
	 * @param name
	 * @param photoSpecie
	 * @param amount
	 * @param typeSpecie
	 */
	public void Specie(String name, String photoSpecie, int amount, String typeSpecie) {
		this.name = name;
		this.photoSpecie = photoSpecie;
		this.amount = amount;
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

	public int getAmount() {
		return amount;
	}

	/**
	 * 
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPhotoSpecie() {
		return photoSpecie;
	}

	/**
	 * 
	 * @param photoSpecie
	 */
	public void setPhotoSpecie(String photoSpecie) {
		this.photoSpecie = photoSpecie;
	}

}