package models;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.Valid;

/**
 * Teacher extends AbsctractUser. This class is used to describe an user with teacher's rights.
 * @author DUBUIS Michael
 *
 */
@Entity
public class Teacher extends AbstractUser {
	@ManyToMany
	@CollectionTable(
			name = "TeacherTDs",
			joinColumns = @JoinColumn(name = "UserEmail"))
	@Valid
	private List<EU> td;
	@ManyToMany
	@CollectionTable(
			name = "TeacherTPs",
			joinColumns = @JoinColumn(name = "UserEmail"))
	@Valid
	private List<EU> tp;
	@ManyToMany
	@CollectionTable(
			name = "TeacherCMs",
			joinColumns = @JoinColumn(name = "UserEmail"))
	@Valid
	private List<EU> cm;
	
	/**
	 * Empty Constructor
	 */
	public Teacher() {
		super();
	}

	/**
	 * @return the td
	 */
	public List<EU> getTd() {
		return td;
	}

	/**
	 * @param td the td to set
	 */
	public void setTd(List<EU> td) {
		this.td = td;
	}

	/**
	 * @return the tp
	 */
	public List<EU> getTp() {
		return tp;
	}

	/**
	 * @param tp the tp to set
	 */
	public void setTp(List<EU> tp) {
		this.tp = tp;
	}

	/**
	 * @return the cm
	 */
	public List<EU> getCm() {
		return cm;
	}

	/**
	 * @param cm the cm to set
	 */
	public void setCm(List<EU> cm) {
		this.cm = cm;
	}
	
	public void setTeacher (String lastName, String firstName, String email, Date birthDate, Map<PhoneType, String> phones, String website){
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setBirthDate(birthDate);
		this.setEmail(email);
		this.setPhones(phones);
		this.setWebSite(website);
	}
	
	// TODO UTILS TOOLS FOR TEACHER (ADDERS & REMOVERS)
}
