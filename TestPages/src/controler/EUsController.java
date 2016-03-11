package controler;

import java.util.ArrayList;
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
	UE eu = new UE();
	List<UE> eus;
	
	public EUsController (){
		euM = new ManagerEUs();
		eu = new UE();
		eus = new ArrayList<UE>();
	}
	
	


	public String save(UE ue) {
			euM.add(ue);
			return "eus";
	}
	
	public String delete(UE ue) {
		euM.remove(ue);
		return "eus";
}

	
	public List<UE> findAll(){
		eus = euM.findAll();
		System.out.println("debut");
		for (UE ue : eus) {
			System.out.println(eu.getName());
		}
		return eus;
	}
	
	public String show(String id) {
		eu = euM.find(id);
		return "showPerson";
	}
	
	
	
	public ManagerEUs getEuM() {
		return euM;
	}
	
	
	public void setEuM(ManagerEUs euM) {
		this.euM = euM;
	}
	
	
	public List<UE> getEus() {
		return eus;
	}
	
	public void setEus(ArrayList<UE> eus) {
		this.eus = eus;
	}
	
	public UE getEu() {
		return eu;
	}
	
	
	public void setEu(UE eu) {
		this.eu = eu;
	}
}