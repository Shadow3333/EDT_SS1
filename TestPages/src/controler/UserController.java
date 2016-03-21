package controler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import manager.EducationalBackgroundManager;
import manager.UserManager;
import models.AbstractUser;
import models.Admin;
import models.Courses;
import models.EU;
import models.GroupEU;
import models.Student;
import models.Teacher;
import models.User;
import util.Role;
import util.UserException;

@ManagedBean(name = "UserController")
@SessionScoped
public class UserController {
	
	UserManager userM;
	EducationalBackgroundManager ebM;
	AbstractUser theUser;
	Courses eb;
	String role;
	List<EU> optionals;
	
	List<User> users = new ArrayList<User>();
	
	public UserController(){
		userM = new UserManager();
		ebM = new EducationalBackgroundManager();
		theUser = new Admin();
		eb = new Courses();
		optionals = new ArrayList<EU>();
	}
	
	public String save()
	{
		AbstractUser user = roleToObject();
		userM.save(user);
		theUser = new Admin();
		return "users";
	}
	
	public AbstractUser roleToObject()
	{
		AbstractUser user = null;
		switch (getUserType()) {
		case Admin:
			user = new Admin();
			break;
			
		case Teacher:
			user = new Teacher();
			break;
				
		case Student:
			user = new Student();
			break;
		
		default:
			//gestion err
		}
		user.setEmail(theUser.getEmail());
		user.setPassword(theUser.getHashPwd());
		user.setFirstName(theUser.getFirstName());
		user.setLastName(theUser.getLastName());
		user.setBirthDate(theUser.getBirthDate());
		user.setWebSite(theUser.getWebSite());
		user.setPhones(theUser.getPhones());
		return user;
	}
	
	public String update()
	{
		AbstractUser user = roleToObject();
		userM.update(user);
		theUser = new Admin();
		return "users";
	}
	
	public String show(AbstractUser user)
	{
		theUser.copy(user);
		return "editUser";
	}
	
	public void remove(AbstractUser user){
		userM.delete(user);
	}
	
	public List<String> getRoles()
    {
    	List<String> myList = new ArrayList<String>();
    	for (Role currRole : Role.values()) {
			myList.add(currRole.toString());
		}
    	return myList;
    }
	
	public List<Courses> findAllEBs() throws UserException
	{
		if (theUser == null) {
			throw new UserException();
		}
		List<Courses> list = ebM.findAll();
		if (list.isEmpty() == false) {
			eb = list.get(0);
		}
		return list;
	}
	
	public String doER(AbstractUser user)
	{
		theUser = user;
		return "educationalRegistration";
	}
	
	public List<EU> getEBOptionals()
    {
    	return eb.getEUs();
    }
	
	public String saveER() throws UserException
	{
		
		if (theUser == null) {
			optionals = new ArrayList<EU>();
			return "users";
		}
		if (theUser.getClass().equals(Student.class)) {
			List<GroupEU> listGrEU = new ArrayList<GroupEU>();
			listGrEU.add(eb.getObligatories());
			GroupEU tempo;
			for (EU eu : optionals) {
				tempo = new GroupEU();
				tempo.addEU(eu);
				listGrEU.add(tempo);
			}
			((Student)theUser).setGroups(listGrEU);
			((Student)theUser).setIdCourses(eb.getId());
			optionals = new ArrayList<EU>();
			return "users";
		}
		optionals = new ArrayList<EU>();
		return "errUser";
		
	}
	
	public List<AbstractUser> findAll()
	{
		for (AbstractUser eu : userM.findAll()) {
			System.out.println(eu.getEmail() + " : " + eu.getClass().getSimpleName());
		}
		return userM.findAll();
	}
	
	public Role getUserType()
	{
		return Role.valueOf(role);
	}
	
	public String getFormattedDate(Date date)
	{
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");//dd/MM/yyyy
	    return sdfDate.format(date);
	}
	
	public String getRole()
	{
		return role;
	}
	
	public AbstractUser newUser()
	{
		theUser = new Admin();
		return theUser;
	}
	
	public String getRole(AbstractUser user)
	{
		return user.getClass().getSimpleName();
	}

	public void setRole(String role) {
		this.role = role;
	}

	public AbstractUser getTheUser() {
		return theUser;
	}

	public void setTheUser(User theUser) {
		this.theUser = theUser;
	}

	public Courses getEb() {
		return eb;
	}

	public void setEb(Courses eb) {
		this.eb = eb;
	}

	public void setOptionals(List<EU> optionals) {
		this.optionals = optionals;
	}

	public List<EU> getOptionals() {
		return optionals;
	}
	
	/***
	 * This method returns a person's with no mail.
	 * @return a person
	 */
//	@ModelAttribute("person")
//	public User getMail() {
//		User p = new User();
//		return p;
//	}

	
}
