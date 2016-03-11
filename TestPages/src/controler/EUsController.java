package controler;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import manager.ManagerEUs;
import models.UE;

/**
 * 
 * @author
 *
 */
@ManagedBean(name = "euController")
@SessionScoped
public class EUsController {

	ManagerEUs euM;
	@Autowired
	UE theEU;
	
	public EUsController (){
		euM = new ManagerEUs();
		theEU = new UE();
	}
	
	


	public String save() {
			euM.add(theEU);
			theEU.reset();
			return "eus";
	}
	
	public String delete(UE ue) {
		System.out.println("test");
		euM.remove(ue);
		System.out.println(ue.getName());
		return "eus";
}
		
	
	public List<UE> findAll(){
		return euM.findAll();
	}
	
	public String show(String id) {
		theEU = euM.find(id);
		return "showPerson";
	}
	
	
	
	public ManagerEUs getEuM() {
		return euM;
	}
	
	
	public void setEuM(ManagerEUs euM) {
		this.euM = euM;
	}
	
	public UE getTheEU() {
		return theEU;
	}

	public void setTheEU(UE theEU) {
		this.theEU = theEU;
	}
	
}