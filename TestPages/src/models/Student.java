package models;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.Valid;

import models.AbstractUser.PhoneType;

/**
 * Student extends AbsctractUser. This class is used to describe an user with student's rights.
 * @author DUBUIS Michael
 *
 */
@Entity
public class Student extends AbstractUser {
	@Column(nullable = true)
	private String idCourses;
	@ManyToMany
	@CollectionTable(
			name = "StudentGroupsEU",
			joinColumns = @JoinColumn(name = "UserEmail"))
	@Valid
	private List<GroupEU> groups;
	
	/**
	 * Empty Constructor
	 */
	public Student() {
		super();
	}

	/**
	 * @return the idCourses
	 */
	public String getIdCourses() {
		return idCourses;
	}

	/**
	 * @param idCourses the idCourses to set
	 */
	public void setIdCourses(String idCourses) {
		this.idCourses = idCourses;
	}

	/**
	 * @return the groups
	 */
	public List<GroupEU> getGroups() {
		return groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(List<GroupEU> groups) {
		this.groups = groups;
	}
	
	
	public void setStudent (String lastName, String firstName, String email, Date birthDate, Map<PhoneType, String> phones, String website){
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setBirthDate(birthDate);
		this.setEmail(email);
		this.setPhones(phones);
		this.setWebSite(website);
	}
	// TODO UTILS TOOLS FOR STUDENT (ADDERS & REMOVERS)
}
