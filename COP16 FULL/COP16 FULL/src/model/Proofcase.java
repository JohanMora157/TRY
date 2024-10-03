
package model;

public class Proofcase {

	private String description;
	private String name;

	/**
	 * 
	 * @param description
	 * @param name
	 */
	public Proofcase(String description, String name) {
		this.description = description;
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
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

}