package controler;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import manager.ManagerEUs;
import models.EU;

/**
 * 
 * @author
 *
 */
@ManagedBean(name = "euController")
@SessionScoped
public class EUsController {

	ManagerEUs euM;
	EU theEU;
	
	public EUsController (){
		euM = new ManagerEUs();
		theEU = new EU();
	}

	public String save() {
			euM.save(theEU);
			theEU.reset();
			return "eus";
	}
	
	public String remove(EU ue) {
		euM.remove(ue);
		return "eus";
}
		
	
	public List<EU> findAll(){
		return euM.findAll();
	}
	
	public ManagerEUs getEuM() {
		return euM;
	}
	
	
	public void setEuM(ManagerEUs euM) {
		this.euM = euM;
	}
	
	public EU getTheEU() {
		return theEU;
	}

	public void setTheEU(EU theEU) {
		this.theEU = theEU;
	}
	
}