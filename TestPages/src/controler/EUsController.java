package controler;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import manager.ManagerEUs;
import models.UE;

/**
 * 
 * @author
 *
 */
@ManagedBean(name = "euController")
public class EUsController {

	ManagerEUs euM = new ManagerEUs();
	UE eu = new UE();
	List<UE> eus = new ArrayList<UE>();
	
	public EUsController (){
		eus = euM.findAll();
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
		return eus;
	}
	
	public String show(String id) {
		eu = euM.find(id);
		return "showPerson";
	}
	
}