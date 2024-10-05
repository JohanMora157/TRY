
package model;

public class Specie {

	private String name;
	private int amount;
	private String photoSpecie;
	private String type;

	public Specie(String name, String photoSpecie, int amount, String type) {
		this.name = name;
		this.photoSpecie = photoSpecie;
		this.amount = amount;
		this.type = type;

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPhotoSpecie() {
		return photoSpecie;
	}

	public void setPhotoSpecie(String photoSpecie) {
		this.photoSpecie = photoSpecie;
	}

	public String toString() {
		return "atriubutos" + "-" + name + "-" + photoSpecie + "-" + amount + "-" + type;
	}

}