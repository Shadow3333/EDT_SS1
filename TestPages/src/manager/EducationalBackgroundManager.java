package manager;

import java.util.ArrayList;
import java.util.List;

import models.Courses;
import models.EU;
import models.GroupEU;

public class EducationalBackgroundManager {

	GroupEU obligatories;
	GroupEU optionnal;
	GroupEU optionnal2;
	
	Courses course;


	List<GroupEU> optionnals;
	List<Courses> courses;
	
	/**
	 * @param dao
	 */
	public EducationalBackgroundManager() {
		
		obligatories = new GroupEU();
		optionnal = new GroupEU();
		
		optionnals = new ArrayList<GroupEU>();
		courses = new ArrayList<Courses>();
		
		EU ue1 = new EU();
		ue1.setId("JEE12");
		ue1.setName("Java entreprise edition");
		ue1.setDescription("est une EU");
		ue1.setNbCredits(23);
		
		EU ue2 = new EU();
		ue2.setId("H0145");
		ue2.setName("haskell");
		ue2.setDescription("est surement une EU");
		ue2.setNbCredits(852);
		
		obligatories.addEU(ue1);
		obligatories.addEU(ue2);
		
		
		EU ue3 = new EU();
		ue3.setId("C1678");
		ue3.setName("Cryptographie");
		ue3.setDescription("est possiblement une EU");
		ue3.setNbCredits(852);
		optionnal.addEU(ue3);
		
		EU ue4 = new EU();
		ue3.setId("M1023");
		ue3.setName("Communication");
		ue3.setDescription("est possiblement une EU");
		ue3.setNbCredits(30);
		optionnal.addEU(ue4);
		
		EU ue5 = new EU();
		ue3.setId("J1033");
		ue3.setName("Anglais");
		ue3.setDescription("est possiblement une EU");
		ue3.setNbCredits(30);
		optionnal2.addEU(ue5);
		
		optionnals.add(optionnal);
		optionnals.add(optionnal2);
		
		course.setObligatories(obligatories);
		course.setOptions(optionnals);
		
		courses.add(course);

	}

	public void save (Courses course){
		courses.add(course);
	}
	
	public void remove (Courses course){
		courses.remove(course);
	}
	
	public List<Courses> findAll (){
		return courses;
	}
	
	public Courses find (String id){
		for ( Courses course : courses){
			if (course.getId() == id)
				return course;
		}
		return null;
	}
}
