package model;

public class Representative {

	private String name;
	private String phoneNumber;

	/**
	 * 
	 * @param name
	 * @param phoneNumber
	 */
	public Representative(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String toString() {
		return "atriubutos" + "-" + name + "-" + phoneNumber;
	}
}