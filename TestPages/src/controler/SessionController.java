package controler;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import manager.SessionManager;
import models.EU;
import models.GroupStudent;
import models.Session;
import models.Teacher;

@ManagedBean(name = "sessionController")
@SessionScoped
public class SessionController {
	
	SessionManager sessionM;
	Session theSession;
	List<Session> sessions;
	EUsController euM;


	public SessionController(){
		sessionM = new SessionManager();
		sessions = new ArrayList<Session>();
		theSession = new Session();
		euM = new EUsController();
	}
	
	
	public String save(Session session) {
		sessions.add(session);
		sessionM.save(session);
		return "sessions";
	}
	
	public String remove(Session session) {
		sessionM.remove(session);
		return "sessions";
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


	public void setTheSession(Session theSession) {
		this.theSession = theSession;
	}


	public List<Session> getSessions() {
		return sessions;
	}


	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

}
