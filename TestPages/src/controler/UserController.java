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
		theUser = new User();
		eb = new Courses();
	}
	
	public String save()
	{
		switch (getUserType()) {
		case Admin:
			Admin admin = new Admin();
			admin.copy(theUser);
			userM.save(admin);
			break;
			
		case Teacher:
			Teacher teacher = new Teacher();
			teacher.copy(theUser);
			userM.save(teacher);
			break;
				
		case Student:
			Student student = new Student();
			student.copy(theUser);
			userM.save(student);
			break;
		
		default:
			//gestion err
			break;
		}
		
		theUser.reset();
		return "users";
	}
	
	public String update()
	{
		
		userM.update(theUser);
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
	
	public List<Courses> findAllEBs()
	{
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
	
	public List<EU> getOptionals()
    {
    	return eb.getEUs();
    }
	
	public String saveER()
	{
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
			return "educationalRegistration";
		}
		return "errUser";
	}
	
	public List<AbstractUser> findAll()
	{
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
		theUser.reset();
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
