package models;

import java.util.Map;


public class UE {
	
	public static enum LessonType {
		TD,
		TP,
		CM,
		Other
	}
	
	private String id;
	private String name;
	private String description;
	private Integer nbCredits;
	private Map<LessonType, Integer> nbHours;


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the nbCredits
	 */
	public Integer getNbCredits() {
		return nbCredits;
	}

	/**
	 * @param nbCredits the nbCredits to set
	 */
	public void setNbCredits(Integer nbCredits) {
		this.nbCredits = nbCredits;
	}

	/**
	 * @return the nbHours
	 */
	public Map<LessonType, Integer> getNbHours() {
		return nbHours;
	}

	/**
	 * @param nbHours the nbHours to set
	 */
	public void setNbHours(Map<LessonType, Integer> nbHours) {
		this.nbHours = nbHours;
	}

}
