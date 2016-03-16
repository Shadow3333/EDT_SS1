package manager;

import java.util.ArrayList;
import java.util.List;

import models.Courses;
import models.EU;
import models.GroupEU;

public class EducationalBackgroundManager {

	ManagerEUs euM;
	List<Courses> courses;
	
	/**
	 * @param dao
	 */
	public EducationalBackgroundManager() {
		
		GroupEU obligatories;
		GroupEU optionnal;
		GroupEU optionnal2;
		
		GroupEU obligatoriesEB2;
		GroupEU optionnalEB2;
		
		List<GroupEU> optionnals;
		List<GroupEU> optionnalsEB2;
		
		obligatories = new GroupEU();
		optionnal = new GroupEU();
		optionnal2 = new GroupEU();
		obligatoriesEB2 = new GroupEU();
		optionnalEB2 = new GroupEU();
		Courses course = new Courses();
		Courses course1 = new Courses();
		
		optionnalsEB2 = new ArrayList<GroupEU>();
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
		
		EU ue3 = new EU();
		ue3.setId("C1678");
		ue3.setName("Cryptographie");
		ue3.setDescription("est possiblement une EU");
		ue3.setNbCredits(852);
		
		EU ue4 = new EU();
		ue4.setId("M1023");
		ue4.setName("Communication");
		ue4.setDescription("est peut être une EU");
		ue4.setNbCredits(30);
		
		EU ue5 = new EU();
		ue5.setId("J1033");
		ue5.setName("Anglais");
		ue5.setDescription("peut être une EU");
		ue5.setNbCredits(30);
		
		
		obligatories.addEU(ue1);
		obligatories.addEU(ue2);
		optionnal.addEU(ue3);
		optionnal.addEU(ue4);
		optionnal2.addEU(ue5);
		
		obligatoriesEB2.addEU(ue4);
		obligatoriesEB2.addEU(ue3);
		
		optionnalEB2.addEU(ue1);
		
		optionnalsEB2.add(optionnalEB2);
		
		optionnals.add(optionnal);
		optionnals.add(optionnal2);
		
		course.setObligatories(obligatories);
		course.setOptions(optionnals);
		course1.setObligatories(obligatoriesEB2);
		course1.setOptions(optionnalsEB2);
		
		course1.setId("P2578");
		course1.setName("FSIL");
		
		course.setId("P0123");
		course.setName("ISL");
		
		courses.add(course);
		courses.add(course1);

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
	
	public void update(Courses eb)
	{
		for (Courses currEB : courses) {
			if (currEB.getId().equals(eb.getId())) {
				currEB = eb;
			}
		}
	}
}
