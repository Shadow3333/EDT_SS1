package controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import manager.UserManager;
import models.User;

public class UserController {
	
	UserManager userM = new UserManager();
	User thPerson = new User();
	
	List<User> users = new ArrayList<User>();
	
	public UserController(){
		users = userM.findAll();
	}
	
	public void save(User user){
		this.thPerson = user;
		userM.add(user);
	}
	
	public void remove(User user){
		userM.delete(user);
	}
	
	/***
	 * This method returns a person's with no mail.
	 * @return a person
	 */
	@ModelAttribute("person")
	public User getMail() {
		User p = new User();
		return p;
	}

	
}
