package models;

import java.util.Map;


public class EU {
	
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
	
	public void reset()
	{
		this.id = null;
		this.name = null;
		this.description = null;
		this.nbCredits = null;
	}
	
	public void copy(EU ue)
	{
		this.name = ue.getName();
		this.id = ue.getId();
		this.description = ue.getDescription();
		this.nbCredits = ue.getNbCredits();
	}

	 public boolean equals(Object other) {
	        return other instanceof EU && (id != null) ? id.equals(((EU) other).id) : (other == this);
	    }

	    // This must return the same hashcode for every Foo object with the same key.
	    public int hashCode() {
	        return id != null ? this.getClass().hashCode() + id.hashCode() : super.hashCode();
	    }

	    // Override Object#toString() so that it returns a human readable String representation.
	    // It is not required by the Converter or so, it just pleases the reading in the logs.
	    public String toString() {
	        return "EU";
	    }
	
}
