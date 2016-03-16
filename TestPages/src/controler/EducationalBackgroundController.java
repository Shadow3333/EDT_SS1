package controler;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import manager.EducationalBackgroundManager;
import models.Courses;
import models.EU;
import models.GroupEU;

/**
 * 
 * @author
 *
 */
@ManagedBean(name = "EducationalBackgroundController")
@SessionScoped
public class EducationalBackgroundController {

	EducationalBackgroundManager EBM;
	EUsController euM;
	Courses theEducationalBackground;
	List<EU> optionals;
	
	public EducationalBackgroundController (){
		EBM = new EducationalBackgroundManager();
		euM = new EUsController();
		init();
	}

	public String save() {
		GroupEU tempo;
		for (EU eu : optionals) {
			tempo = new GroupEU();
			tempo.addEU(eu);
			theEducationalBackground.addOptions(tempo);
		}
		EBM.save(theEducationalBackground);
		init();
		return "eus";
	}
	
	public String remove(Courses educationalBackground) {
		EBM.remove(educationalBackground);
		return "eus";
	}
		
	public List<EU> findAllEUs()
	{
		return euM.findAll();
	}

	public Courses getTheEducationalBackground() {
		return theEducationalBackground;
	}

	public void setTheEducationalBackground(Courses theEducationalBackground) {
		this.theEducationalBackground = theEducationalBackground;
	}

	public EducationalBackgroundManager getEBM() {
		return EBM;
	}

	public void setEBM(EducationalBackgroundManager eBM) {
		EBM = eBM;
	}

	public EUsController getEuM() {
		return euM;
	}

	public void setEuM(EUsController euM) {
		this.euM = euM;
	}

	public List<EU> getOptionals() {
		return optionals;
	}

	public void setOptionals(List<EU> optionals) {
		this.optionals = optionals;
	}
	
	public void init()
	{
		theEducationalBackground = new Courses();
		GroupEU gEU = new GroupEU();
		gEU.setEus(new ArrayList<EU>());
		theEducationalBackground.setObligatories(gEU);
		optionals = new ArrayList<EU>();
	}
	
}