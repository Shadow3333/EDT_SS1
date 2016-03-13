package controler;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import manager.UserManager;
import models.Admin;
import models.Student;
import models.Teacher;
import models.User;
import util.UserType;

@ManagedBean(name = "UserController")
@SessionScoped
public class UserController {
	
	UserManager userM;
	User theUser;
	String userT;
	
	List<User> users = new ArrayList<User>();
	
	public UserController(){
		userM = new UserManager();
		theUser = new User();
	}
	
	public void save(){
		switch (getEnumUserT()) {
		case Admin:
			Admin admin = new Admin();
			admin.copy(theUser);
			userM.add(admin);
			break;
			
		case Teacher:
			Teacher teacher = new Teacher();
			teacher.copy(theUser);
			userM.add(teacher);
			break;
				
		case Student:
			Student student = new Student();
			student.copy(theUser);
			userM.add(student);
			break;
		}
		
		theUser.reset();
	}
	
	public void remove(User user){
		userM.delete(user);
	}
	
	public List<String> getUsersType()
    {
    	List<String> myList = new ArrayList<String>();
    	for (UserType userT : UserType.values()) {
			myList.add(userT.toString());
		}
    	return myList;
    }

	public UserType getEnumUserT()
	{
		return UserType.valueOf(userT);
	}

	public String getUserT() {
		return userT;
	}

	public void setUserT(String userT) {
		this.userT = userT;
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
