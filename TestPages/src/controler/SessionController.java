package controler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import manager.SessionManager;
import models.Session;

@ManagedBean(name = "sessionController")
@SessionScoped
public class SessionController {
	
	SessionManager sessionM;
	Session theSession;
	
	

}
