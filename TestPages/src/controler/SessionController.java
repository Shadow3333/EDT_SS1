package controler;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import manager.SessionManager;
import models.EU;
import models.EU.LessonType;
import models.GroupStudent;
import models.Session;
import models.Teacher;

@ManagedBean(name = "sessionController")
@SessionScoped
public class SessionController {
	
	SessionManager sessionM;
	Session theSession;
	EUsController euM;


	public SessionController(){
		sessionM = new SessionManager();
		theSession = new Session();
		euM = new EUsController();
	}
	
	
	public String save() {
		sessionM.save(theSession);
		theSession = new Session();
		return "sessions";
	}
	
	public String remove(Session session) {
		sessionM.remove(session);
		return "sessions";
	}
	
	public LessonType[] getLessonType()
	{
		return LessonType.values();
	}
	
	public List<Session> findAll(){
		return sessionM.findAll();
	}
	
	public List<GroupStudent> findAllGroups(){
		return sessionM.findAllGroups();
	}
	
	public List<Teacher> findAllTeachers (){
		return sessionM.findAllTeachers();
	}
	
	public List<EU> findAllEUS(){
		return euM.findAll();
	}
	
	public Session getTheSession() {
		return theSession;
	}


	public EUsController getEuM() {
		return euM;
	}


	public void setEuM(EUsController euM) {
		this.euM = euM;
	}


	public void setTheSession(Session theSession) {
		this.theSession = theSession;
	}

}
