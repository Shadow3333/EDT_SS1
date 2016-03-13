package controler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import manager.UserManager;
import models.AbstractUser;
import models.Admin;
import models.Student;
import models.Teacher;
import models.User;
import util.Role;

@ManagedBean(name = "UserController")
@SessionScoped
public class UserController {
	
	UserManager userM;
	User theUser;
	String role;
	
	List<User> users = new ArrayList<User>();
	
	public UserController(){
		userM = new UserManager();
		theUser = new User();
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
	
	public User newUser()
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

	public User getTheUser() {
		return theUser;
	}

	public void setTheUser(User theUser) {
		this.theUser = theUser;
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
