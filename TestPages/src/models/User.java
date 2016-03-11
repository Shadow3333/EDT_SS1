package models;

import java.util.Date;
import java.util.Map;


public class User {
	
	public static enum PhoneType {
		mobile,
		home,
		work
	}
	

	private String email;
	private String hashPwd;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String webSite;
	private Map<PhoneType, String> phones;
	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the hashPwd
	 */
	public String getHashPwd() {
		return hashPwd;
	}

	/**
	 * @param hashPwd the hashPwd to set
	 */
	public void setHashPwd(String hashPwd) {
		this.hashPwd = hashPwd;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the webSite
	 */
	public String getWebSite() {
		return webSite;
	}

	/**
	 * @param webSite the webSite to set
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	/**
	 * @return the phones
	 */
	public Map<PhoneType, String> getPhones() {
		return phones;
	}

	/**
	 * @param phones the phones to set
	 */
	public void setPhones(Map<PhoneType, String> phones) {
		this.phones = phones;
	}
	
	/**
	 * set hashPwd with hash of password
	 * @param password
	 */
	public void setPassword(String password) {
		hashPwd = password;
	}

}
