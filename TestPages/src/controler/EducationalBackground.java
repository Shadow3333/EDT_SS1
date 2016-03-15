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
@ManagedBean(name = "EducationalBackground")
@SessionScoped
public class EducationalBackground {

	EducationalBackgroundManager EBM;
	EUsController euM;
	Courses theEducationalBackground;
	List<EU> optionals;
	
	public EducationalBackground (){
		EBM = new EducationalBackgroundManager();
		euM = new EUsController();
		theEducationalBackground = new Courses();
		theEducationalBackground.setObligatories(new GroupEU());
		optionals = new ArrayList<EU>();
	}

	public String save() {
		GroupEU tempo;
		for (EU eu : optionals) {
			tempo = new GroupEU();
			tempo.addEU(eu);
			theEducationalBackground.addOptions(tempo);
		}
		EBM.save(theEducationalBackground);
		theEducationalBackground = new Courses();
		return "eus";
	}
	
	public String remove(Courses educationalBackground) {
		EBM.remove(educationalBackground);
		return "eus";
	}
		
	
	public List<EU> findAllEUs(){
		return euM.findAll();
	}
	
	
}