package manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.AbstractUser;
import models.Admin;
import models.Teacher;
import models.User;

public class UserManager {
	
	List<AbstractUser> users;
	
	public UserManager() {
		users = new ArrayList<AbstractUser>();
		Admin admin1 = new Admin();
		admin1.setBirthDate(new Date("11/11/1111"));
		admin1.setEmail("mail@mail.mail");
		admin1.setFirstName("Jean");
		admin1.setLastName("Yvon");
		admin1.setHashPwd("pwd1");
		admin1.setWebSite("webSite1");
		Teacher Teacher1 = new Teacher();
		Teacher1.setBirthDate(new Date("12/12/1212"));
		Teacher1.setEmail("mail2@mail.mail");
		Teacher1.setFirstName("Romain");
		Teacher1.setLastName("Phong");
		Teacher1.setHashPwd("pwd2");
		Teacher1.setWebSite("webSite2");
		users.add(Teacher1);
		users.add(admin1);
	}
	
	public void save (AbstractUser user){
		users.add(user);
	}

	public void delete (AbstractUser user){
		users.remove(user);
	}
	
	public List<AbstractUser> findAll(){
		return users;
	}
	
	public void update(AbstractUser user)
	{
		System.out.println(users.contains(user));
	}
	
	public User find(){return null;}
	
}
